package dishes.execute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import dishes.factory.DishFactory;
import dishes.model.Trader;
import dishes.model.Transaction;

public class Execute {

	public static void main(String[] args) {
		//DishFactory.createTransaction().stream().filter(t -> t.getYear() == 2011).distinct()
			//	.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList()).forEach(System.out::println);
		
		//DishFactory.createTransaction().stream().map(t->t.getTrader().getCity()).distinct().collect(Collectors.toList()).forEach(System.out::println);
		
//		DishFactory.createTransaction().
//		stream().filter(t->t.getTrader().getCity().equals("Cambridge"))
//		.distinct().sorted(Comparator.comparing()).collect(Collectors.toList()).forEach(System.out::println);		
//		
		String name = DishFactory.createTransaction().stream().map(t->t.getTrader().getName()).sorted().collect(Collectors.joining(" "));
		
//		DishFactory.createTransaction().stream()
//		.filter(t->t.getTrader().getCity().equalsIgnoreCase("cambridge"))
//		.map(Transaction::getValue).collect(Collectors.toList()).forEach(System.out::println);
		
//		int max =DishFactory.createTransaction().stream().map(Transaction::getValue).reduce(0, Integer::max);
//		int maxa =DishFactory.createTransaction().stream().map(Transaction::getValue).reduce(Integer::max).get();
//		int smallest =DishFactory.createTransaction().stream().map(Transaction::getValue).reduce(Integer::min).get();
//		System.out.println(smallest);
		
//		String name="ABCDEFGHIJK";
//		String result = name.substring(0, 5);
//		System.out.println(result);
		
		
		
	}

}
