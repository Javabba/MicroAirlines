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




	public void print() {
		System.out.println("Flight "+code);
		System.out.println("At "+departure.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		System.out.println("From : "+origin.getName());
		System.out.println("To   : "+destination.getName());
		System.out.println("Using a "+plane.getModel());
		
	}
		

	
	
	

}
