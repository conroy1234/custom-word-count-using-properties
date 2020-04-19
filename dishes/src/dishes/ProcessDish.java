package dishes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dishes.model.Dish;

public class ProcessDish {
	static List<Dish> low = streamingLowCal();
	static List<Dish> heigh = streaming();

	public static void main(String[] args) {
		//low.stream().map(Dish::getProduct).forEach(System.out::println);
		//List<Dish> d= streaminga();
		//d.stream().forEach(System.out::println);
		long count =heigh.stream().map(Dish::getColories).limit(4).count();
		System.out.println(count);
		//System.out.println(mapping().get("chicken"));
	}

	public static List<Dish> streaming() {
		return DishFactory.getLowCalariesDish().stream().filter(d -> d.getColories() ==20)
				.sorted(Comparator.comparing(Dish::getColories)).collect(Collectors.toList());
	}
	
	
	public static List<Dish> streamingLowCal() {
		return DishFactory.getLowCalariesDish().stream().filter(d -> d.getColories() < 7)
				.sorted(Comparator.comparing(Dish::getColories)).collect(Collectors.toList());
	}
	

	public static Map<String,List<Dish>> mapping() {
		Map<String, List<Dish>> map = DishFactory.getLowCalariesDish().stream()
				.collect(Collectors.groupingBy(d->{
					if(d.getColories()<10) 
						
						return "Diet";
					else
					return null;
				}));
		return map;
	}

	public static void findChicken() {
		DishFactory.getLowCalariesDish().stream()
				.filter(c -> c.getName().contentEquals("chicken") && c.getColories() > 6)
				.map(d -> d.getName() + " colories: " + d.getColories()).collect(Collectors.toList())
				.forEach(System.out::println);
		// .sorted(Comparator.comparing(Dish::getColories)).map(Dish::getName).collect(Collectors.toList()).forEach(System.out::println);
	}

}
