package threads;

public class Tprod extends Thread{
	
	public void run() {
		ProductFactory factory = new ProductFactory();
		factory.populateProduct();
		factory.getAllProducts();
		//System.out.println("THE RESULT IS>>>>>>>"+ result+" \n");
	}

}
