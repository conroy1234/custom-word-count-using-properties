package thread.producer.consumer.practice;

import java.util.List;

public class Producer implements Runnable {

	private static final int LIMIT = 5;
	List<String> messageList= null;
	private int questionNumber=0;
	
	public Producer(List<String> messageList) {	
		this.messageList = messageList;
	}

	public void produceQuestion(int questionNumber) throws InterruptedException {
		synchronized (messageList) {
			while(messageList.size()==LIMIT) {
				System.out.println("Producer is full will resume in a minute");
				messageList.wait();
			}
			
			Thread.sleep(100);
			System.out.println("new message "+ questionNumber);
			messageList.add("question"+ questionNumber);
			messageList.notify();
		}
		
		
	}

	
	@Override
	public void run() {
		while(true) {
			try {
				produceQuestion(questionNumber++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
}
