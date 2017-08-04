==============================================================================================================================
This is a simple application that lets users select seats and reserve a seat in a stage.

MY assumption is that the stage which is a multidimensional Array with column and rows ,
and initialized empty stage at initialization with seats that generates SeatId and for 
simplicity followed the row and col to access.The program is built using maven build tool and
 tested using  junit testing .The following are the classes and interfeces that reside in the program.

       INTERFACE:-TicketService
	 CLASSES :-TicketServiceImpl which implements the TicketService Interface  ,

	 Customer class which holds customer information.
	 
     Seat class which holds the seatId ,hold and reserved 	boolean variables .

	 	 SeatHold class which holds the seat for a particular customer and consists of list of seats,customer and seatHoldId.
		 
		 Application class consists of the main method. for tesing purpose we have the TicketServiceTest class 
		 
		 For testing case i initialized a stage that have twenty rows and twenty column having two customers and have testing cases 
		 which tests 1)holding of a seat 
		              2)hold that is not available
					  3)reserved seats
		  
		
		 
		 To run the program we go to git and follow the following steps
 		 1)git clone  https://github.com/mail2yonz/walmartassesemet.git
		 2)mvn clean install 
		 
============================================================================================================================================== # walmartjavaassessment

