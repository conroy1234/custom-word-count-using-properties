package dishes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dishes.model.Dish;

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

	public static void main(String[] args) {
//		Map<Integer,List<Dish>> dt=getLowCalariesDish().stream().filter(d->d.getColories()<7).filter(d->d.getName()=="tuna")
//		.sorted(Comparator.comparing(Dish::getColories)).collect(Collectors.groupingBy(Dish::getColories));
//		
//		System.out.println(dt.get(5));

		// fizBuz().stream().filter(i->i % 2
		// !=0).skip(2).collect(Collectors.toList()).forEach(System.out::println);
		// fizBuzd().stream().map(s->s.split("")).flatMap(Arrays::stream).collect(Collectors.toList()).forEach(System.out::println);
		// fizBuz().stream().map(n->n).map(n->n*n).collect(Collectors.toList()).forEach(System.out::println);

		// int sum = fizBuz().stream().reduce(Integer::min).get();
		int conSum = getLowCalariesDish().stream().map(Dish::getColories).reduce(Integer::min).get();
		int sum = fizBuz().stream().reduce(Integer::min).get();
		System.out.println(conSum);
		System.out.println(sum);
		getLowCalariesDish().stream().filter(t -> t.getName() == "canebridge").distinct()
				.sorted(Comparator.comparing(Dish::getName)).collect(Collectors.toList());

	}

	public static List<Integer> fizBuz() {
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		return number;
	}

	public static List<String> fizBuzd() {
		List<String> number = Arrays.asList("one", "two", "three");
		return number;
	}

}
