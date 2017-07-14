package MA;
import java.util.ArrayList;

public class MicroAirlines {
	
	static ArrayList<Flight> flights = new ArrayList<Flight>();

	
	public static void main(String[] args) {

		Plane plan1=new Plane(6, 4, "DC0");
		Plane plan2=new Plane(10, 8, "DC1");
		Plane plan3=new Plane(8, 8, "DC2");
		
		Airport ap1 = new Airport("Stockholm", "ARN");
		Airport ap2 = new Airport("Oslo", "OSL");
		Airport ap3 = new Airport("Göteborg", "GOT");
		
		
		flights.add(new Flight("SK156", ap1, ap2, "2017-08-01 08:00", plan1));		
		flights.add(new Flight("SK157", ap2, ap1, "2017-08-01 18:00", plan1));
		flights.add(new Flight("SK212", ap1, ap3, "2017-08-01 10:00", plan2));
		flights.add(new Flight("SK213", ap3, ap1, "2017-08-01 16:00", plan2));
		flights.add(new Flight("SK378", ap2, ap3, "2017-08-01 12:00", plan3));
		flights.add(new Flight("SK379", ap3, ap2, "2017-08-01 20:00", plan3));
		
//		flights.add(new Flight("SK158", ap1, ap2, "2017-08-02 08:00", plan1));		
//		flights.add(new Flight("SK159", ap2, ap1, "2017-08-02 18:00", plan1));
//		flights.add(new Flight("SK214", ap1, ap3, "2017-08-02 10:00", plan2));
//		flights.add(new Flight("SK215", ap3, ap1, "2017-08-02 16:00", plan2));
//		flights.add(new Flight("SK380", ap2, ap3, "2017-08-02 12:00", plan3));
//		flights.add(new Flight("SK381", ap3, ap2, "2017-08-02 20:00", plan3));		
		
//		flights.add(new Flight("SK160", ap1, ap2, "2017-08-03 08:00", plan1));		
//		flights.add(new Flight("SK161", ap2, ap1, "2017-08-03 18:00", plan1));
//		flights.add(new Flight("SK216", ap1, ap3, "2017-08-03 10:00", plan2));
//		flights.add(new Flight("SK217", ap3, ap1, "2017-08-03 16:00", plan2));
//		flights.add(new Flight("SK382", ap2, ap3, "2017-08-03 12:00", plan3));
//		flights.add(new Flight("SK383", ap3, ap2, "2017-08-03 20:00", plan3));	
		
		NiceMeal.nice.add(new NiceMeal("GooseliverPie with Caviar and really expensive sauce", 999));
		NiceMeal.nice.add(new NiceMeal("Cognacs Flambered Grouse with Hunter Potatoes", 499));
		NiceMeal.nice.add(new NiceMeal("Smoked Reindeer with Västerbotten sauce and Dollarpotatoes", 599));
		NiceMeal.nice.add(new NiceMeal("LobsterSoup with garlic bread and champagne", 399));

		CheapMeal.cheap.add(new CheapMeal("Pigwash with Water and Bread", 99));
		CheapMeal.cheap.add(new CheapMeal("VeganSallad", 79));
		
		
		
		Booking b1 = new Booking("Anders Andersson", flights.get(0), TicketClassesEnum.ECONOMY, false, null);
		Booking b2 = new Booking("Bertil Bodén", flights.get(0), TicketClassesEnum.ECONOMY , false, null);
		Booking b3 = new Booking("Cajsa Canin", flights.get(0), TicketClassesEnum.FIRSTCLASS, true, NiceMeal.nice.get(1));
		Booking b4 = new Booking("David Davidsson", flights.get(0), TicketClassesEnum.ECONOMY , false, null);
		
		Booking b5 = new Booking("Erik Eriksson", flights.get(1), TicketClassesEnum.ECONOMY , true, CheapMeal.cheap.get(1));
		Booking b6 = new Booking("Filippa Filipsson", flights.get(1), TicketClassesEnum.FIRSTCLASS, true, NiceMeal.nice.get(0));
		Booking b7 = new Booking("Gustaf Gustavsson", flights.get(1), TicketClassesEnum.ECONOMY, true, CheapMeal.cheap.get(0));
		Booking b8 = new Booking("Helge Helgesson", flights.get(1), TicketClassesEnum.FIRSTCLASS,  false, null);
		
		Booking b9 = new Booking("Ida Idegran", flights.get(2), TicketClassesEnum.ECONOMY , true, CheapMeal.cheap.get(1));
		Booking b10 = new Booking("Johanna Jester", flights.get(2), TicketClassesEnum.FIRSTCLASS, true, NiceMeal.nice.get(3));
		Booking b11 = new Booking("Kurt Klant", flights.get(2), TicketClassesEnum.ECONOMY, false, null);
		Booking b12 = new Booking("Linda Ledig", flights.get(2), TicketClassesEnum.FIRSTCLASS, true, NiceMeal.nice.get(2));
		
		
		
		
		flights.get(0).book(b1); 
		flights.get(0).book(b2);
		flights.get(0).book(b3);
		flights.get(0).book(b4);
		flights.get(1).book(b5);
		flights.get(1).book(b6);
		flights.get(1).book(b7);
		flights.get(1).book(b8);	
		flights.get(2).book(b9);
		flights.get(2).book(b10);
		flights.get(2).book(b11);
		flights.get(2).book(b12);	
		
		//flights.get(0).print();
		
		//BusinessLogic.printFlightList();
		
	
		//BusinessLogic.doBooking();
		
		//flights.get(0).print();
		
		
		
		
		
		//while(true);
		
		Menu.mainMenu();
		

	}
	
	public static String fStr(String in, int len) {
		return (in+"                                                            ").substring(0, len);
	}

}
