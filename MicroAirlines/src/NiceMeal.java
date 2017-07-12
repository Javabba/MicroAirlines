import java.util.ArrayList;
// tjena Karl
public class NiceMeal extends Meal {

	static ArrayList<NiceMeal> nice = new ArrayList<NiceMeal>();

	public NiceMeal(String mealName, int price) {
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
