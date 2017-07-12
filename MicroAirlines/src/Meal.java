public class Meal {
	
	String MealName;
	int price;
	
<<<<<<< HEAD
	public Meal(String mealName, int price) {
		MealName = mealName;
=======
	
	
	public Meal(TicketClassesEnum mealType, String mealName, int price) {
		super();
		this.mealType = mealType;
		this.mealName = mealName;
>>>>>>> branch 'master' of https://github.com/kghultland/MicroAirlines.git
		this.price = price;
		
	}
<<<<<<< HEAD
	public String getMeal() {
		return MealName;
	}
=======



	public TicketClassesEnum getMealType() {
		return mealType;
	}



	public String getMealName() {
		return mealName;
	}



	public int getPrice() {
		return price;
	}

	
	
>>>>>>> branch 'master' of https://github.com/kghultland/MicroAirlines.git
	
}
