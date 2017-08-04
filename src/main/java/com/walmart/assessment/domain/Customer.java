package com.walmart.assessment.domain;

import java.util.Date;
/*CUSTOMER CLASS*/
public class Customer {
	
	private  String Customer_Email;
	private  Date dob;
	private String Customer_FirstName;
	private String Customer_LastName;

	public Customer(String cust_email,Date dob_Age,String cust_fname,String cust_lname)
	
	{
		
		
		this.dob=dob;
		this.Customer_Email=cust_email;
		this.Customer_FirstName=cust_fname;
		this.Customer_LastName=cust_lname;
	}
	

	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public String getCustomer_Email() {
		return Customer_Email;
	}
	public void setCustomer_Email(String Customer_Email) {
		Customer_Email = Customer_Email;
	}
	public Date getCustomer_Age() {
		return dob;
	}
	public void setCustomer_Age(Date dob) {
		this.dob = dob;
	}
	public String getCustomer_FirstName() {
		return Customer_FirstName;
	}
	public void setCustomer_FirstName(String customer_FirstName) {
		Customer_FirstName = customer_FirstName;
	}
	public String getCustomer_LastName() {
		return Customer_LastName;
	}
	public void setCustomer_LastName(String customer_LastName) {
		Customer_LastName = customer_LastName;
	}
	
}
