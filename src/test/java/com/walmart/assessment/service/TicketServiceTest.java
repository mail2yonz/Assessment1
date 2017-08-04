package com.walmart.assessment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.walmart.assessment.domain.Customer;
import com.walmart.assessment.domain.Seat;
import com.walmart.assessment.domain.SeatHold;


public class TicketServiceTest {

	private TicketService ticketService;
	
	
	@Before
	public void setup(){
		Seat[][] seats= new Seat[20][20];
		Map<String,Customer> customers= new HashMap<>();
	    Customer customer1= new Customer("mail2yonz@gmail.com",new Date("09/22/1984"),"yonatan","mengesha");
	    Customer customer2= new Customer("@yahoo.com",new Date("08/07/1977"),"solomon","tadese");
	    customers.put("@yahoo.com", customer2);
	    customers.put("mail2yonz@gmail.com", customer1);
		ticketService = new TicketServiceImpl(seats, customers, 20, 20);
	}
	
	@Test
	public void numSeatAvailableTest(){
		int availableSeats = ticketService.numSeatAvailable();
		Assert.assertEquals("Seats should be equal",400, availableSeats);
		Assert.assertNotEquals("Seats should not be", 50,  availableSeats);
	}
	
	@Test
	public void findAndHoldSeatsTest(){
		SeatHold sh = ticketService.findAndHoldSeats(2, "mail2yonz@gmail.com");
		Assert.assertNotNull("Should hold a set", sh);
		Assert.assertEquals("mail2yonz@gmail.com", sh.getCustomer().getCustomer_Email());
		Assert.assertEquals(2, sh.getSeat().size());
		
		int numAvaliable = ticketService.numSeatAvailable();
		Assert.assertEquals("Seats available after holding", 398, numAvaliable);
	}
	
	@Test
	public void findAndHoldSeatsNoAvailableTest(){
		SeatHold sh = ticketService.findAndHoldSeats(1000, "mail2yonz@gmail.com");
		Assert.assertNull("Seats shouldnt be avaiable", sh);
	}
	
	
	@Test
	public void reserveSeatsTest()
	{   
	    SeatHold sh = ticketService.findAndHoldSeats(2, "mail2yonz@gmail.com");
		String sreserved=ticketService.reserveSeats(sh.getSeatHoldID(), "mail2yonz@gmail.com");
		Assert.assertEquals("SeatHold has been reserved successfully!!!", sreserved	);
	}
	
	
	
}
