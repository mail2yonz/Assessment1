package com.walmart.assessment.domain;
/*CLASS FOR THE SEAT*/
public class Seat {
	
	private String seatID;
	public boolean hold;
	public boolean reserved;
	
	public Seat()
	{
		
	}
	public Seat(String seatID,boolean hold,boolean reserved)
	{
		this.seatID=seatID;
		this.hold=hold;
		this.reserved=reserved;
	}

	
	public String getSeatID() {
		return seatID;
	}
	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}
	public boolean isHold() {
		return hold;
	}
	public void seatHold(boolean hold) {
		this.hold = hold;
	}
	public boolean isReserved() {
		return reserved;
	}
	public void seatReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
}
