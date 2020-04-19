package thread.producer.consumer.practice;

import java.util.List;

public class MyProducer implements Runnable{

	private List<Integer> list = null;
	private int LIMIT=5;
	private int numerOfAccurance;
	
	
	public MyProducer(List<Integer> list) {
		this.list = list;
	}

	public void produce(int numerOfAccurance) throws InterruptedException {
		synchronized (list) {
			while(list.size()==LIMIT) {
				System.out.println(" waiting collection is full");
				list.wait();
			}
			
			System.out.println("new "+numerOfAccurance);
			Thread.sleep(200);
			list.add(numerOfAccurance);
			list.notify();
			
		}
		
	}
	
	public void store() {
		System.out.println("the size of the list >>>>>>>>>>"+list.size());
	}
	
	@Override
	public void run() {
		
	while(true) {
		try {
			produce(numerOfAccurance++);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	}
}
