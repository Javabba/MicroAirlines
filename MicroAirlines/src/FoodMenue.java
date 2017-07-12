import java.util.ArrayList;

public class FoodMenue {
	
	ArrayList<Meal> mealList = new ArrayList<Meal>();

	
	
	
	public FoodMenue() {
		super();
		
		mealList.add(new Meal(TicketClassesEnum.ECONOMY, "Meatballs", 50));
		
		mealList.add(new Meal(TicketClassesEnum.FIRSTCLASS, "Filet Mignon", 195));		
		
		
	}
	
	
	
	

}
