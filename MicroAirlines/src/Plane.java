
public class Plane {
	
	private int economySeats;
	private int firstclassSeats;
	
	
	public int getEconomySeats() {
		return economySeats;
	}

	public int getFirstclassSeats() {
		return firstclassSeats;
	}
	
	public int totalSeats() {
		return economySeats+firstclassSeats;
	}

	public Plane(int numEconomySeats, int numFirstclassSeats) {	
		this.economySeats=numEconomySeats;
		this.firstclassSeats=numFirstclassSeats;
	}

}
