package threads;

public class Work extends Thread {
private String name;
private Sequence sequence;

	public Work(String name, Sequence sequesnc) {
	this.name = name;
	this.sequence = sequesnc;
}


	public void run() {
		Thread.currentThread().setName(this.name);
		for(int i=0; i<100;i++) {
			System.out.println(sequence.next() +" - "+Thread.currentThread().getName());
			
		}
	}
}
