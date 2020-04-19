package dishes.factory;

import java.util.Arrays;
import java.util.List;

import dishes.Type;
import dishes.model.Dish;
import dishes.model.Trader;
import dishes.model.Transaction;

public class DishFactory {
	public static List<Dish> getLowCalariesDish() {
		List<Dish> dishes = Arrays.asList(new Dish("chicken", 12, false, Type.MEAT),
				new Dish("beef", 20, false, Type.MEAT), new Dish("pork", 45, false, Type.MEAT),
				new Dish("lamb", 20, false, Type.MEAT), new Dish("tuna", 5, false, Type.MEAT),
				new Dish("macril", 7, false, Type.MEAT), new Dish("milk", 100, false, Type.OTHER),
				new Dish("cabbage", 2, true, Type.VEGETARIAN), new Dish("calaloo", 2, true, Type.VEGETARIAN),
				new Dish("spenage", 2, true, Type.VEGETARIAN), new Dish("yam", 4, true, Type.VEGETARIAN),
				new Dish("carrot", 3, true, Type.VEGETARIAN), new Dish("onion", 1, true, Type.VEGETARIAN),
				new Dish("beetruit", 2, true, Type.VEGETARIAN), new Dish("coconut", 5, true, Type.VEGETARIAN),
				new Dish("potato", 5, true, Type.VEGETARIAN), new Dish("sweet potato", 4, true, Type.VEGETARIAN),
				new Dish("planting", 3, true, Type.VEGETARIAN), new Dish("banana", 2, true, Type.VEGETARIAN));

		return dishes;

	}

	public static List<Transaction> createTransaction() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transaction = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2011, 700), new Transaction(alan, 2012, 950));
		return transaction;

	}

}
