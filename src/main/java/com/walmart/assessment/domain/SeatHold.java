package com.walmart.assessment.domain;

import java.util.List;
/*SEATHOLD CLASS THAT HOLDS THE SEAT*/
public class SeatHold {
	
	private List<Seat> seat;
	private Customer customer;
	private int seatHoldID;
	
	public int getSeatHoldID() {
		return seatHoldID;
	}
	public void setSeatHoldID(int seatHoldID) {
		this.seatHoldID = seatHoldID;
	}
	
	public SeatHold(List<Seat> seat,Customer customer,int seatHoldID)
	{
		this.seat=seat;
		this.customer=customer;
		this.seatHoldID=seatHoldID;
	}
	
	public List<Seat> getSeat() {
		return seat;
	}

	public void setSeat(List<Seat> seat) {
		this.seat = seat;
	}



	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
