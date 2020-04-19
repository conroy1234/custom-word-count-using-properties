package thread.producer.consumer.practice;

import java.util.List;

public class MyConsumer implements Runnable{

	private List<Integer> list = null;
	
	
	
	public MyConsumer(List<Integer> list) {		
		this.list = list;
	}

	public void consume() throws InterruptedException {
		synchronized (list) {			
		
		while(list.isEmpty()) {
			System.out.println("consumer waiting");
			list.wait();
		}
		
		System.out.println(" removing "+list.remove(0));
		Thread.sleep(5000);
		list.notify();
		store();
		}
		
		
	}

	public void store() {
		System.out.println("the size of the list consumer >>>>>>>>>>"+list.size());
	}
	
	
	@Override
	public void run() {
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
