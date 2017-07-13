
public class Booking {
	
	private String passengerName;
	private String bookingNr;
	
	private Flight flight;
	private TicketClassesEnum ticketClass;
	
	private int flightPrice;
	private int mealPrice;
	
	private boolean wantToEat;
	private Meal selectedMeal;
	
	
	public Booking(String name, Flight flight, TicketClassesEnum ticketClass, int flightPrice, int mealPrice, boolean wantToEat, Meal selectedMeal) {
		passengerName = name;
		bookingNr=getNewBookingNr();
		this.ticketClass = ticketClass;
		this.flight=flight;
		this.flightPrice=flightPrice;
		this.mealPrice= mealPrice;
		this.wantToEat = wantToEat;
		this.selectedMeal = selectedMeal;		
	}
	
	
	private String getNewBookingNr() {		
		return "XX1YY";
	}


	public String getPassengerName() {
		return passengerName;
	}


	public String getBookingNr() {
		return bookingNr;
	}



	public Flight getFlight() {
		return flight;
	}



	public TicketClassesEnum getTicketClass() {
		return ticketClass;
	}



	public int getFlightPrice() {
		return flightPrice;
	}





	public int getMealPrice() {
		return mealPrice;
	}





	public boolean isWantToEat() {
		return wantToEat;
	}




	public Meal getSelectedMeal() {
		return selectedMeal;
	}



	

}
