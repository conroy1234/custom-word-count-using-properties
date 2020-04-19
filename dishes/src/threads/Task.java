package threads;

public class Task extends Thread {
private String name;


	public Task(String name) {	
	this.name = name;
}


	public void run() {
		Thread.currentThread().setName(this.name);
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
}
