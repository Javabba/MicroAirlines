
public class Meal {
	
	private TicketClassesEnum mealType;
	private String mealName;
	private int price;	
	
	
	
	public Meal(TicketClassesEnum mealType, String mealName, int price) {
		super();
		this.mealType = mealType;
		this.mealName = mealName;
		this.price = price;
	}



	public TicketClassesEnum getMealType() {
		return mealType;
	}



	public String getMealName() {
		return mealName;
	}



	public int getPrice() {
		return price;
	}

	
	
	
}
