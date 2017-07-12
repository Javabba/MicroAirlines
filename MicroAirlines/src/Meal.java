
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

}
