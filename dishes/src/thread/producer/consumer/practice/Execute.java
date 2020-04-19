package thread.producer.consumer.practice;

import java.util.ArrayList;
import java.util.List;

public class Execute {

	public static void main(String[] args) {
		List<String> messageList = new ArrayList<>();
		messageList.add("d");
		Thread producer = new Thread(new Producer(messageList));
		Thread consumer = new Thread(new Consumer(messageList));
		
		producer.start();
		consumer.start();
	}

}
