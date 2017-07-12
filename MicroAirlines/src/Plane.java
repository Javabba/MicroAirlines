
public class Plane {
	
	private String model;
	private int economySeats;
	private int firstclassSeats;
	
	
	public int getEconomySeats() {
		return economySeats;
	}

	public int getFirstclassSeats() {
		return firstclassSeats;
	}
	
	public String getModel() {
		return model;
	}
	
	public int totalSeats() {
		return economySeats+firstclassSeats;
	}

	public Plane(int numEconomySeats, int numFirstclassSeats, String model) {	
		this.economySeats=numEconomySeats;
		this.firstclassSeats=numFirstclassSeats;
		this.model=model;
	}

}
