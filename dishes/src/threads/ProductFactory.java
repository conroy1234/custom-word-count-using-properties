package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProductFactory {

	List<Product> products = new CopyOnWriteArrayList<>();

	public List<Product> populateProduct() {
		for (int i = 0; i < 100; i++) {
			products.add(new Product(i, "product" + i));
			System.out.println("POPULATING");
		}
		return products;

	}

	public void getAllProducts() {

		for (Product prod : products) {
			Thread.currentThread().setName(prod.getName());
			System.out.println(prod + " " + Thread.currentThread().getName());
		}

	}

	public String getAllProducts2() {
		String result = "";
		for (Product prod : products) {
			Thread.currentThread().setName(prod.getName());
			result += prod.toString();
		}
		return result;

	}
}
