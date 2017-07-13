
public class Meal {
	
	String mealName;
	int price;
	

	public Meal(String mealName, int price) {
		this.mealName = mealName;

		
	}


	public String getMealName() {
		return mealName;
	}



	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return mealName + ": SEK " + price;
	}

	
	

	
}
