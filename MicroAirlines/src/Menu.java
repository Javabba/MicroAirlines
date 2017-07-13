import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
//	Hej Karl!
	static Scanner in = new Scanner(System.in);
	String val = in.nextLine();
	
	public static void main (String [] args) {
		Menu.mainMenu();
	}
public static void mainMenu(){
	
		System.out.println("|------------------------MICRO AIRLINES-------------------------|");
		System.out.println("|...............Flight or fight is not a question...............|");
		System.out.println("|          1.) Customer         |      2.) Personel             |");
		System.out.println("|---------------------------------------------------------------|");
		String val = in.nextLine();
		switch (val) {
		default:
			System.out.println("Chose 1.) or 2.) please.");
			mainMenu();
			
			
		break;
		case "1":
				customerMenu();
		break;
		
		case "2": 
				personelMenu();
		break; 
		
		case "0": 
			System.out.println("Hasta La Vista...Baby!");
			System.exit(0);
		
		}
	
}

	public static void customerMenu() {
		System.out.println("|------------------------MICRO AIRLINES-------------------------|");
		System.out.println("|...............Flight or fight is not a question...............|");
		System.out.println("|      1.) Book your flight.    |     2.) Unbook your flight.   |");
		System.out.println("|                        0.) Main Menu.                         |");
		System.out.println("|---------------------------------------------------------------|");
		String val = in.nextLine();
		
		switch (val) {
		default:
			System.out.println("Chose 1.), 2.) or 0.) please.");
			customerMenu();
			
		break;
		case "1":
//				BusinessLogic.doBooking();
		break;
		
		case "2": 
//				BusinessLogic.doUnbooking();
		break; 
		
		case "0": 
				mainMenu();
		
		}
		
	}
		public static void personelMenu() {
			System.out.println("|------------------------MICRO AIRLINES-----------------------|");
			System.out.println("|...............Flight or fight is not a question.............|");
			System.out.println("|         1.) List Flight.      |       4.) Add Flight        |");
			System.out.println("|         2.) List Booking      |       5.) Add Plane    	  |");
			System.out.println("|         3.) Profit     	    |       6.) List Booking      |");
			System.out.println("|                        0.) Main Menu.                       |");
			System.out.println("|-------------------------------------------------------------|");
			String val = in.nextLine();
			
			switch (val) {
			default:
				System.out.println("Chose 1.)...to...9.) please");
				personelMenu();
				
			break;
			case "1":
	//				BusinessLogic.Karl();
			break;
			
			case "2": 
	//				BusinessLogic.Karl();
			break; 
			
			case "3": 
	//				BusinessLogic.Karl();
			break; 
			
			case "4": 
	//           	BusinessLogic.Karl();
			break; 
						
			case "5": 
	//				BusinessLogic.Karl();
			break; 
						
			case "6": 
	//		 		BusinessLogic.Karl();
			break; 
						
			case "7": 
	//				BusinessLogic.Karl();
			break; 
						
			case "8": 
	//          	BusinessLogic.Karl();
			break; 
						
			case "9": 
	//				BusinessLogic.Karl();
			break; 
			
			case "0": 
					mainMenu();
			
			}
			
	}	

}