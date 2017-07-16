package MA;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BusinessLogic {
	
	static Scanner in = new Scanner(System.in);
	
	
	
	
	static public void doBooking( ) {
		
		Booking newBooking;
		
		//MicroAirlines.flights.add(arg0)
		
		System.out.println("Name of passenger?");
		String name = in.nextLine();
		
		printFlightList();
		
		
		int flightIdx=integerInput("What flight do you want to book?", MicroAirlines.flights.size());
		
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
			System.out.println("Do you want to order food?(y/n)");
			temp = in.nextLine().substring(0,1).toUpperCase();
		} while ( (!temp.equals("Y"))  && !temp.equals("N")) ;
		
		boolean wantToEat=false;
		Meal selectedMeal=null;
		
		if (temp.equals("Y")) { 
			wantToEat=true;		
			printFoodMenu(ticket);

			int mealIdx=-1;
			
			
			
			if (ticket==TicketClassesEnum.ECONOMY) {
				mealIdx = integerInput("What food do you want to order?", CheapMeal.cheap.size() );
				selectedMeal=CheapMeal.cheap.get(mealIdx);
			} else {
				mealIdx = integerInput("What food do you want to order?", NiceMeal.nice.size() );
				selectedMeal=NiceMeal.nice.get(mealIdx);
			}
		};
				
		
		newBooking = new Booking(name, MicroAirlines.flights.get(flightIdx), ticket, wantToEat, selectedMeal);
		
		MicroAirlines.flights.get(flightIdx).book(newBooking);
		
		
		
		//System.out.println("\n\nBooking reference="+newBooking.getBookingNr());
		
		printTicket(newBooking);
		
			
		
	}


	
	static void printTicket(Booking newBooking) {
		
		String nr = newBooking.getBookingNr();
		String name = newBooking.getPassengerName();
		TicketClassesEnum type = newBooking.getTicketClass();
		String seat = ""+(newBooking.getSeatNumber());
		Flight flight = newBooking.getFlight();
		String meal=""; 
		
		if (newBooking.getSelectedMeal()!=null) {
			meal=newBooking.getSelectedMeal().getMealName();	
		}else{
		    meal ="not included ";
		 }
		int FlightPrice = newBooking.getFlightPrice();
		int MealPrice =  newBooking.getMealPrice();
		String TicketPrice =""+ (FlightPrice + MealPrice); // Obs!! TOM String "" + interna inom paranteser g�r s� allt blir parsat till en string...Karl �r BRUTAL!
	
		String payed = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//		DateTimeFormatter dfFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String checkIn = newBooking.getFlight().getDeparture().minusHours(1).toString().replace("T", " ");
		int centeredMeal1= 30-(meal.length()/2);
		int centeredMeal2 = 30-(meal.length()/2) + meal.length()%2 +1;
		
		meal = fStr(String.format("%"+centeredMeal1+"s%s%"+centeredMeal2+"s", "",meal,""), 61);
		
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println("|                     MicroAirlines - TICKET                        |");
		System.out.println("| |---------------------------------------------------------------| |");
		System.out.println("| |     Passenger: " + fStr(name,47)+"| |");
		System.out.println("| |    Booking nr: " + nr + " " + fStr(type.toString(),12)+ "Seat: "+ fStr(seat.toString(),24)+"| |");
		System.out.println("| |        Flight: " + fStr(flight.toString(),47) +"| |");
		System.out.println("| |                                                               | |");
		System.out.println("| |---------------------Inflight catering-------------------------| |");
//		System.out.println("| |  " + fStr(meal.toString(),61) +"| |");
		System.out.println("| |"+ meal +"  | |");
		System.out.println("| |---------------------------------------------------------------| |");
		System.out.println("| |           " + payed + " Payed in Cash: SEK " + fStr(TicketPrice,15)  + " | |");
		System.out.println("| |   Check in at least 1 hour before takeoff: " + checkIn +"   | |");
		System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
		System.out.println(meal);
		
		
		
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
		
		int flightIdx=integerInput("What flight do you want to print?", MicroAirlines.flights.size());
		
		MicroAirlines.flights.get(flightIdx).print();
		
	}
	
	
	static public void printFlightList() {
		for (int i=0; i< MicroAirlines.flights.size(); i++) {
			System.out.println(i+" "+MicroAirlines.flights.get(i));
		}
	}
		
	static public void printSeatListFood(Flight f, boolean singleNumber) {
		int seat=1;//start with seat 1
		
		System.out.println("Seats First class");

		for (int i=0; i< f.firstclassBookings.length; i++) {
			System.out.print(fStr("Seat "+seat+" ", 10));
			if ( f.firstclassBookings[i] == null) System.out.println(fStr("<empty>",25)); 
			else {
				System.out.print(fStr(f.firstclassBookings[i].getPassengerName(),25));		

				if (f.firstclassBookings[i].isWantToEat()) {
					System.out.println(" < "+f.firstclassBookings[i].getSelectedMeal()+" >");
				} else System.out.println(" <no food ordered >");		
			}
			seat++;
		}
		if (singleNumber==false) // if not single number then reset seat between firstclass/economy
			seat=1; 
		
		System.out.println("\nSeats Economy class");
		

		for (int i=0; i< f.economyBookings.length; i++) {
			System.out.print(fStr("Seat "+seat+" ", 10));
			if ( f.economyBookings[i] == null) System.out.println(fStr("<empty>", 25)); 
			else {
				System.out.print(fStr(f.economyBookings[i].getPassengerName(),25));
				
				if (f.economyBookings[i].isWantToEat()) {
					System.out.println(" < "+f.economyBookings[i].getSelectedMeal()+" >");
				} else System.out.println(" < no food ordered >");
				
			}
			seat++;
		}

		
	}
		
	static public void printSeatListCode(Flight f, boolean singleNumber) {
		int seat=1;//start with seat 1
		
		System.out.println("Seats First class");

		for (int i=0; i< f.firstclassBookings.length; i++) {
			System.out.print(fStr("Seat "+seat+" ", 10));
			if ( f.firstclassBookings[i] == null) System.out.println(fStr("<empty>",25)); 
			else {
				System.out.print(fStr(f.firstclassBookings[i].getPassengerName(),25));		
				System.out.println("Booking code: "+f.firstclassBookings[i].getBookingNr());
			}
			seat++;
		}
		if (singleNumber==false) // if not single number then reset seat between firstclass/economy
			seat=1; 
		
		System.out.println("\nSeats Economy class");
		

		for (int i=0; i< f.economyBookings.length; i++) {
			System.out.print(fStr("Seat "+seat+" ", 10));
			if ( f.economyBookings[i] == null) System.out.println(fStr("<empty>", 25)); 
			else {
				System.out.print(fStr(f.economyBookings[i].getPassengerName(),25));
				System.out.println("Booking code: "+f.economyBookings[i].getBookingNr());		
			}
			seat++;
		}

		
	}		
		
	public static String fStr(String in, int len) {
		return (in+"                                                            ").substring(0, len);
	}

	public static void doUnbooking() {
		
		System.out.println("What booking code do you want to unbook?");
		String bookingCode = in.nextLine().toUpperCase();
		
		Flight f=null;
		int seat = 0;
		
		bookingFound: 
			for (int i=0; i<MicroAirlines.flights.size(); i++) {
			f=MicroAirlines.flights.get(i);
					
			for (int j=0; j<f.getFirstclassBookings().length; j++) {	
				if (f.getFirstclassBookings()[j]!=null)
					if (f.getFirstclassBookings()[j].getBookingNr().equals(bookingCode)) {
						seat=f.getFirstclassBookings()[j].getSeatNumber();
						break bookingFound;					
				}
			}
			
			for (int j=0; j<f.getEconomyBookings().length; j++) {	
				if (f.getEconomyBookings()[j]!=null)
					if (f.getEconomyBookings()[j].getBookingNr().equals(bookingCode)) {
						seat=f.getEconomyBookings()[j].getSeatNumber();
						break bookingFound;					
				}
			}					
		}
		
		if (seat==0 || f==null) {
			System.out.println("Booking code "+bookingCode+" not found!");
			return;
		}
		
	//	System.out.println("Seat = "+seat);

		unbookSeat(f, seat);		
	}

	public static void doListBooking() {
		BusinessLogic.printFlightList();
		
		int flightIdx=integerInput("What flight do you want to list?", MicroAirlines.flights.size());
		
		printSeatListCode(MicroAirlines.flights.get(flightIdx), true);
		
	}

	public static void doUnbookPassenger() {
		BusinessLogic.printFlightList();
		
		int flightIdx=integerInput("What flight do you want to unbook from?", MicroAirlines.flights.size());
		
		printSeatListCode(MicroAirlines.flights.get(flightIdx), true);
		
		int seatNumber=integerInput("What seat do you want to unbook?", MicroAirlines.flights.get(flightIdx).economyBookings.length +   
										MicroAirlines.flights.get(flightIdx).firstclassBookings.length );
		
		unbookSeat(MicroAirlines.flights.get(flightIdx), seatNumber);
				
	}

	private static void unbookSeat(Flight flight, int seatNumber) {
		if (seatNumber>=flight.getFirstclassBookings().length) {
			// ECONOMY Class
			seatNumber--;
			seatNumber-= flight.getFirstclassBookings().length;
			flight.getEconomyBookings()[seatNumber]=null;	
		} else {
			// FIRST CLASS
			seatNumber--;
			flight.getFirstclassBookings()[seatNumber]=null;	
		}
	}

	public static void doCheckProfit() {
		BusinessLogic.printFlightList();
		
		int flightIdx=-integerInput("What flight do you want to get economic info about?", MicroAirlines.flights.size());
		
	
		Flight f=MicroAirlines.flights.get(flightIdx);
			
		int totalFood=0;
		int totalTicket=0;
		int profit=0;
		
		for (int i=0; i< f.firstclassBookings.length; i++) {
			if ( f.firstclassBookings[i]!=null) {
				totalFood += f.firstclassBookings[i].getMealPrice();
				totalTicket += f.firstclassBookings[i].getFlightPrice();
			}
		}
		
		for (int i=0; i< f.economyBookings.length; i++) {
			if ( f.economyBookings[i]!=null) {
				totalFood += f.economyBookings[i].getMealPrice();
				totalTicket += f.economyBookings[i].getFlightPrice();
			}				
		}
		
		profit = totalFood+totalTicket;
		profit *= 0.3;
	
		String headLine = "Buissnes of flight "+ f.getCode();
		System.out.println(headLine);
		System.out.println("totalFood="+totalFood);
		System.out.println("totalTicket="+totalTicket);
		System.out.println("Profit ="+profit);
				
	}

	private static int integerInput(String text, int count) {
		int temp=-1;
		boolean valid=false;
		
		do {
			do {
				try {
					System.out.println(text);
					temp = Integer.parseInt(in.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Invalid number!");
				}
			} while (true);
			
			if (temp>=0 && temp<count)
				valid=true;
			else
				System.out.println("Number out of range!");
			
		} while(!valid);
		
		
		return temp;
	}	
	

}
