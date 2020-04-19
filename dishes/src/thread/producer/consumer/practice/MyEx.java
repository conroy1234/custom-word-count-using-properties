package thread.producer.consumer.practice;

import java.util.ArrayList;
import java.util.List;

public class MyEx {
	static List<Integer> list= new ArrayList<Integer>();
	public static void main(String[] args) {
		
	Thread producer  = new Thread(new MyProducer(list));
	Thread consumer  = new Thread(new MyConsumer(list));
	
	producer.start();
	consumer.start();

	}

	
	
}
