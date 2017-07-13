
public class Booking {
	
	private String passengerName;
	private String bookingNr;
	
	private Flight flight;
	private TicketClassesEnum ticketClass;
	
	private int flightPrice;
	private int mealPrice;
	
	private boolean wantToEat;
	private Meal selectedMeal;
	
	
	public Booking(String name, Flight flight, TicketClassesEnum ticketClass,   boolean wantToEat, Meal selectedMeal) {
		passengerName = name;
		bookingNr=getNewBookingNr();
		this.ticketClass = ticketClass;
		this.flight=flight;
		this.flightPrice=ticketClass.price();
	
		this.wantToEat = wantToEat;
		this.selectedMeal = selectedMeal;
		if (selectedMeal==null)
			this.mealPrice= 0;
		else
			this.mealPrice=selectedMeal.getPrice();
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
