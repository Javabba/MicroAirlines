package MA;
import java.util.ArrayList;
// tjena Karl NU GÅR DET DÅLIGT...
public class NiceMeal extends Meal {

	static ArrayList<NiceMeal> nice = new ArrayList<NiceMeal>();

	public NiceMeal(String mealName, int price) {
		super(mealName, price);
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
