import java.util.Scanner;

public class BusinessLogic {
	
	static Scanner in = new Scanner(System.in);
	
	
	
	
	static public void doBooking( ) {
		
		Booking newBooking;
		
		//MicroAirlines.flights.add(arg0)
		
		System.out.println("Name of passenger?");
		String name = in.nextLine();
		
		printFlightList();
		
		System.out.println("What flight do you want to book?");
		int flightIdx= Integer.parseInt(in.nextLine());
		
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
		
		
			
		newBooking = new Booking(name, MicroAirlines.flights.get(flightIdx), ticket, 0, 0, false, null);
		MicroAirlines.flights.get(flightIdx).book(newBooking);
			
		
	}
	
	
	static public void printFlightList() {
		for (int i=0; i< MicroAirlines.flights.size(); i++) {
			System.out.println(i+" "+MicroAirlines.flights.get(i));
		}
		
		
		
	}
	
	

}
