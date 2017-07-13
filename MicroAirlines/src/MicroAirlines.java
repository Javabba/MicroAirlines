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
		
		flights.add(new Flight("SK158", ap1, ap2, "2017-08-02 08:00", plan1));		
		flights.add(new Flight("SK159", ap2, ap1, "2017-08-02 18:00", plan1));
		flights.add(new Flight("SK214", ap1, ap3, "2017-08-02 10:00", plan2));
		flights.add(new Flight("SK215", ap3, ap1, "2017-08-02 16:00", plan2));
		flights.add(new Flight("SK380", ap2, ap3, "2017-08-02 12:00", plan3));
		flights.add(new Flight("SK381", ap3, ap2, "2017-08-02 20:00", plan3));		
		
		flights.add(new Flight("SK160", ap1, ap2, "2017-08-03 08:00", plan1));		
		flights.add(new Flight("SK161", ap2, ap1, "2017-08-03 18:00", plan1));
		flights.add(new Flight("SK216", ap1, ap3, "2017-08-03 10:00", plan2));
		flights.add(new Flight("SK217", ap3, ap1, "2017-08-03 16:00", plan2));
		flights.add(new Flight("SK382", ap2, ap3, "2017-08-03 12:00", plan3));
		flights.add(new Flight("SK383", ap3, ap2, "2017-08-03 20:00", plan3));	
		
		
		Booking b1 = new Booking("Anders Andersson", flights.get(0), TicketClassesEnum.ECONOMY,  0, false, null);
		Booking b2 = new Booking("Bertil Bo", flights.get(0), TicketClassesEnum.ECONOMY , 0, false, null);
		Booking b3 = new Booking("Conrad Canin", flights.get(0), TicketClassesEnum.FIRSTCLASS, 0, false, null);
		Booking b4 = new Booking("David Duke", flights.get(0), TicketClassesEnum.ECONOMY , 0, false, null);
		Booking b5 = new Booking("Erik Eriksson", flights.get(0), TicketClassesEnum.ECONOMY , 0, false, null);
		Booking b6 = new Booking("Filip Filipsson", flights.get(0), TicketClassesEnum.FIRSTCLASS, 0, false, null);
		Booking b7 = new Booking("Gustaf Gustavsson", flights.get(0), TicketClassesEnum.ECONOMY, 0, false, null);
		Booking b8 = new Booking("Helge Helgesson", flights.get(0), TicketClassesEnum.FIRSTCLASS, 0, false, null);
		
		flights.get(0).book(b1); 
		flights.get(0).book(b2);
		flights.get(0).book(b3);
		flights.get(0).book(b4);
		flights.get(0).book(b5);
		flights.get(0).book(b6);
		flights.get(0).book(b7);
		flights.get(0).book(b8);		
		
		flights.get(0).print();
		
		BusinessLogic.doBooking();
		
		flights.get(0).print();
		
		//while(true);
		
		//Menu.mainMenu();
		

	}

}
