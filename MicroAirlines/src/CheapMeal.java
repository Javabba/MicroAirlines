import java.util.ArrayList;

public class CheapMeal extends Meal{
	
	static ArrayList <CheapMeal> cheap = new ArrayList<CheapMeal>();

	public CheapMeal(String mealName, int price) {
		super(mealName, price);
		cheap.add(1,new CheapMeal("Pigwash with Water and Bread", 99));
		cheap.add(2,new CheapMeal("VeganSallad", 79));
	}
	
	public String getMealName() {
		return mealName;
	
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
