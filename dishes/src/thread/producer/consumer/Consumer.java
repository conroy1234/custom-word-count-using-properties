package thread.producer.consumer;

import java.util.List;

public class Consumer implements Runnable{

	List<Integer> messageList = null;

	public Consumer(List<Integer> messageList) {
		this.messageList = messageList;
	}
	
	public void answerQuestion() throws InterruptedException {
		synchronized (messageList) {
			while(messageList.isEmpty()) {
				System.out.println(" no message waiting for producer...");
				messageList.wait();
			}
		}
		synchronized (messageList) {
			Thread.sleep(5000);
			System.out.println(" answered Question "+ messageList.remove(0));			
			messageList.notify();
			
		}
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
