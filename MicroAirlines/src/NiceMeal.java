import java.util.ArrayList;
// tjena Karl NU GÅR DET DÅLIGT...
public class NiceMeal extends Meal {

	static ArrayList<NiceMeal> nice = new ArrayList<NiceMeal>();

	public NiceMeal(String mealName, int price) {
		super(mealName, price);
		nice.add(1,new NiceMeal("GooseliverPie with Caviar and really expensive sauce", 999));
		nice.add(2,new NiceMeal("Cognacs Flambered Grouse with Hunter Potatoes", 499));
		nice.add(3,new NiceMeal("Sleep Smoked Reindeer Sadle med Västerbotten Cheese Sause and Dollarpotatoes", 599));
		nice.add(4,new NiceMeal("LobsterSoup with garlic bread and champagne", 399));

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
