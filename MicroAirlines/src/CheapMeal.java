import java.util.ArrayList;

public class CheapMeal extends Meal{
	
	static ArrayList <CheapMeal> nice = new ArrayList<CheapMeal>();

	public CheapMeal(String mealName, int price) {
		super(mealName, price);
	}
	
	public String getMealName() {
		return MealName;
	
	}

	public void setMealName(String mealName) {
		MealName = mealName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
