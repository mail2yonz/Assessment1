package com.walmart.assessment.service;

import com.walmart.assessment.domain.SeatHold;

/*INTERFACE FOR THE TICKETSERVICE*/
public interface TicketService {
	
	int numSeatAvailable();
	
	SeatHold findAndHoldSeats(int numSeats,String customerEmail);
     
	String reserveSeats(int seatHoldId,String customerEmail);
} 
