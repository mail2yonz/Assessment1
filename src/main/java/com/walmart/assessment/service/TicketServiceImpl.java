package com.walmart.assessment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.walmart.assessment.domain.Customer;
import com.walmart.assessment.domain.Seat;
import com.walmart.assessment.domain.SeatHold;


/*IMPLIMENTATION FOR THE TICKET SERVICE */
public class TicketServiceImpl implements TicketService {

	private Seat[][] stage;
	Map<String,Customer> customers;
	Map<Integer,SeatHold> holdedSeats;
	private int counters;
	private int row;
	private int col;
	
/*CONSTRUCTOR FOR THE TICKETSERVICE IMPLEMETATION WITH THREE PARAMETERS*/
	public TicketServiceImpl(Seat[][] stage, Map<String,Customer> customers,int row, int col) {
		this.stage = stage;
		this.customers = customers;
		this.row = row;
		this.col = col;
		holdedSeats = new HashMap<>();
		init(stage);
		
	}
	
/*METHOD FOR AVALABLE SEAT*/
	public int numSeatAvailable() {

		return counters;

	}
	
  /* INITIALIZATION*/
	private  Seat[][] init(Seat[][] seats){
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				String seatId = i + "" + j;
				seats[i][j] = new Seat(seatId, false, false);
				counters++;
			}
		}
		
		return seats;
	}
	
	/*public void display(Seat[][] seats) {
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
			System.out.print(seats[i][j].getSeatID());
			System.out.print(" ");
			}
			System.out.println();
		}
	}*/
	
	
 /*METHOD FOR FINDING SEATS AND HOLDING THEM TEMPORARLY*/
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
		
		List<Seat> seats = new ArrayList<>();
		int numAvaliable = numSeatAvailable();
		
		if(numSeats > numAvaliable){
			return null;
		}
		
		for(int row=0;row<stage.length;row++)
		{
			for(int col=0;col<stage[row].length;col++)
			{
				if(stage[row][col].isHold()==false)
				{
					 
					if(numSeats > 0) {
						 Seat seat = stage[row][col];
					     stage[row][col].seatHold(true);
						 seat.seatHold(true);
					     seats.add(seat);
					     counters--;
					       
					}
					else
					{
						Random rand = new Random();
						int LowNumber = 10;
						int HighNumber = 100;
						int nextInt = rand.nextInt(HighNumber-LowNumber) + LowNumber;
						SeatHold sHold = new SeatHold(seats,customers.get(customerEmail),nextInt);
						holdedSeats.put(sHold.getSeatHoldID(), sHold);
						return sHold;
					}
				     
					numSeats--;  
				      
				}
				
				
			}
			 
		}
		return null;
		
	}
	
	/*METHOD FOR RESERVING SEATS  AFTER THEY HAVE BEEN HODED temporarily*/

	public String reserveSeats(int seatHoldId, String customerEmail) {
		
		
		SeatHold seatHold = holdedSeats.get(seatHoldId);
		
		if(seatHold != null){
			
			List<Seat> seats = seatHold.getSeat();
			for(Seat s : seats){
				s.seatReserved(true);
				
				for(int row=0;row<stage.length;row++)
				{
					for(int col=0;col<stage[row].length;col++)
					{
						if(stage[row][col].isReserved()==false)
						{    
							if(stage[row][col].getSeatID().equals(s.getSeatID())){
								stage[row][col].seatReserved(true);
								break;
							}
						}
					}
					
				}
			}
			
			return "SeatHold has been reserved successfully!!!";
			
		}else {
			return null;
		}

		
		
	}

}
