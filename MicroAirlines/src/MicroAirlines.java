
public class MicroAirlines {

	public static void main(String[] args) {

		Plane plan1=new Plane(5, 5, "R2D2");
		plan1.print();
		
		Airport origin = new Airport("Stockholm", "ARN");
		Airport destination = new Airport("Oslo", "GAR");
		
		origin.print();
		destination.print();
		
		
		
		Flight f1 = new Flight("SK156", origin, destination, "2017-08-01 08:00", plan1);
		f1.print();
		
		//while(true);
		

	}

}
