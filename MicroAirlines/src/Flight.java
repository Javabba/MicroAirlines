import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight {
	private String code;
	private Airport origin;
	private Airport destination;
	private LocalDateTime departure;
	Plane plane;
	
	Booking[] economyBookings;
	Booking[] firstclassBookings;
	
	
	
	
	public Flight(String code, Airport origin, Airport destination, String departure, Plane plane) {
		super();
		this.code=code;
		this.origin = origin;
		this.destination = destination;	
		this.plane = plane;
		
		DateTimeFormatter dfFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		try {
			this.departure = LocalDateTime.parse(departure, dfFormat);
		} catch (Exception e) {
			System.out.println("Wrong Date: (you idiot)  "+departure);			
		}
		
		
		
		this.economyBookings = new Booking[plane.getEconomySeats()];
		this.firstclassBookings = new Booking[plane.getFirstclassSeats()];
		
	}




	public String getCode() {
		return code;
	}




	public Airport getOrigin() {
		return origin;
	}




	public Airport getDestination() {
		return destination;
	}




	public LocalDateTime getDeparture() {
		return departure;
	}




	public Plane getPlane() {
		return plane;
	}




	public Booking[] getEconomyBookings() {
		return economyBookings;
	}




	public Booking[] getFirstclassBookings() {
		return firstclassBookings;
	}


	@Override
	public String toString() {
		String out = departure.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))+" "+code+" "+ 
						origin.getName()+" to "+destination.getName();
		
		return out;
	}
	

	public void print() {
		System.out.println();
		System.out.print("Flight "+code);
		System.out.println(" "+departure.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		System.out.print("From : "+origin.getName());
		System.out.println(" To: "+destination.getName());
		System.out.println("Using a "+plane.getModel());
		System.out.println();
		System.out.println("Seats First class");
		System.out.println("----------------------------------------");
		for (int i=0; i< firstclassBookings.length; i++) {
			System.out.print("Seat "+(i+1)+" ");
			if ( firstclassBookings[i] == null) System.out.println("<empty>"); else System.out.println(firstclassBookings[i].getPassengerName());			
		}
		System.out.println("\nSeats Economy class");
		System.out.println("----------------------------------------");
		for (int i=0; i< economyBookings.length; i++) {
			System.out.print("Seat "+(i+1)+" ");
			if ( economyBookings[i] == null) System.out.println("<empty>"); else System.out.println(economyBookings[i].getPassengerName());			
		}
		System.out.println("----------------------------------------");
	}


	private int firstFree(Booking[] b) {
		for (int i=0; i<b.length; i++)
			if (b[i]==null)
				return i;
		
		return -1;
	}
	
	public boolean book(Booking newBooking) {
		int seat=-1;
		
		if (newBooking.getTicketClass()==TicketClassesEnum.ECONOMY) {
			seat = firstFree(economyBookings);
			if (seat>=0) 
				economyBookings[seat]=newBooking;
			else
				return false;
		} else {
			seat = firstFree(firstclassBookings);
			if (seat>=0) 
				firstclassBookings[seat]=newBooking;
			else
				return false;
		}
			
		
		return true;
	}
	






		

	
	
	

}
