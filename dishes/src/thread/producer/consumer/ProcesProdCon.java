package thread.producer.consumer;

import java.util.ArrayList;
import java.util.List;

public class ProcesProdCon {

	public static void main(String[] args) {
		List<Integer> messageList = new ArrayList<>();
		Thread producetThread = new Thread(new Producer(messageList));

		Thread consumerThread = new Thread(new Consumer(messageList));
		producetThread.start();
		consumerThread.start();
	}

}
