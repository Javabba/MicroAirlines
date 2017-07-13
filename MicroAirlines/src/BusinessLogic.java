import java.util.Scanner;

public class BusinessLogic {
	
	static Scanner in = new Scanner(System.in);
	
	
	
	
	static public void doBooking( ) {
		
		Booking newBooking;
		
		//MicroAirlines.flights.add(arg0)
		
		System.out.println("Name of passenger?");
		String name = in.nextLine();
		
		printFlightList();
		
		
		int flightIdx=-1;
		
		do {
			try {
				System.out.println("What flight do you want to book?");
				flightIdx = Integer.parseInt(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid number");
			}
		} while (true);
		
		String temp;
		do {
			System.out.println("Select F for Firstclass or E for Economyclass");
			temp = in.nextLine().toUpperCase();
		} while ( (!temp.equals("E"))  && !temp.equals("F")) ;
		
		TicketClassesEnum ticket;
		if (temp.equals("E"))
			ticket = TicketClassesEnum.ECONOMY;
		else
			ticket = TicketClassesEnum.FIRSTCLASS;
		
		
		do {
			System.out.println("Do you want to order food?");
			temp = in.nextLine().substring(0,1).toUpperCase();
		} while ( (!temp.equals("Y"))  && !temp.equals("N")) ;
		
		boolean wantToEat=false;
		Meal selectedMeal=null;
		
		if (temp.equals("Y")) { 
			wantToEat=true;		
			printFoodMenu(ticket);

			int mealIdx=-1;
			
			do {
				try {
					System.out.println("What food do you want to order?");
					mealIdx = Integer.parseInt(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid number");
				}
			} while (true);
			
			if (ticket==TicketClassesEnum.ECONOMY) 
				selectedMeal=CheapMeal.cheap.get(mealIdx);
			else
				selectedMeal=NiceMeal.nice.get(mealIdx);
			
		};
				
		
		newBooking = new Booking(name, MicroAirlines.flights.get(flightIdx), ticket, wantToEat, selectedMeal);
		
		MicroAirlines.flights.get(flightIdx).book(newBooking);
		
		
		
		//System.out.println("\n\nBooking reference="+newBooking.getBookingNr());
		
		printTicket(newBooking);
		
			
		
	}
	
	private static void printTicket(Booking newBooking) {
		// TODO Auto-generated method stub ///////////////////////////////////////////////////////////////
		
		
		
	}


	private static void printFoodMenu(TicketClassesEnum ticket) {
		switch(ticket) {
		case ECONOMY:
			for (int i=0; i<CheapMeal.cheap.size(); i++)
				System.out.println(i+" "+ CheapMeal.cheap.get(i).toString());
			break;
		case FIRSTCLASS:
			for (int i=0; i<NiceMeal.nice.size(); i++)
				System.out.println(i+" "+ NiceMeal.nice.get(i).toString());		
			break;
		}
		
	}

	public static void doListFlights() {
		
	BusinessLogic.printFlightList();
		
		int flightIdx=-1;
		
		do {
			try {
				System.out.println("What flight do you want to print?");
				flightIdx = Integer.parseInt(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid number");
			}
		} while (true);
		
		MicroAirlines.flights.get(flightIdx).print();
		
	}
	
	
	static public void printFlightList() {
		for (int i=0; i< MicroAirlines.flights.size(); i++) {
			System.out.println(i+" "+MicroAirlines.flights.get(i));
		}
		
		
		
	}

	public static String fStr(String in, int len) {
		return (in+"                                                            ").substring(0, len);
	}

	
	

}
