package thread.producer.consumer;

import java.util.List;

public class Producer implements Runnable{

	List<Integer> messageList = null;
	
	private int MAX_COUNT=5;
	private int messageNumber;
	
	public Producer(List<Integer> messageList) {		
		this.messageList = messageList;
	}
	
	public void readMessage(int messageNumber) throws InterruptedException {
		synchronized (messageList) {
			while(messageList.size()==MAX_COUNT) {
				System.out.println("list reach the limit");
				messageList.wait();
			}
		}
		
		synchronized (messageList) {
			System.out.println(" new Question "+ messageNumber);
			messageList.add(messageNumber);
			Thread.sleep(100);
			messageList.notify();
			
		}
		
	}

	@Override
	public void run() {
		while(true) {
			try {
				readMessage(messageNumber++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
