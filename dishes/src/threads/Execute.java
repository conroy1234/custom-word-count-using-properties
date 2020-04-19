package threads;

public class Execute {

	public static void main(String[] args) {
		new Task("thread 1").start();
		new Task(" thread 2").start();
		
		Thread thread = new Thread(new Task2("thread 3"));
		thread.start();
		
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				
				Thread.currentThread().setName("thread-4");
				for(int i =0; i<100;i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("printing "+ i + " "+Thread.currentThread().getName());
				}
			}
			
		});
		thread3.start();
	}
	
	

}
