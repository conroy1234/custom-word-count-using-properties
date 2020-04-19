package thread.producer.consumer.practice;

import java.util.List;

public class Consumer implements Runnable {
	private List<String> questionList = null;

	public Consumer(List<String> questionList) {

		this.questionList = questionList;
	}

	public void answerQuestions() throws InterruptedException {
		synchronized (questionList) {
			while(questionList.isEmpty()) {
				System.out.println("consumer is empty please wait until there message available");
				questionList.wait();
			}
			
			Thread.sleep(500);
			System.out.println("answer "+questionList.remove(0));			
			questionList.notify();
		}
		
		
		
	}

	@Override
	public void run() {
		try {
			while(true) {
				answerQuestions();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
