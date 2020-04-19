package threads;

public class TThredRun {

	public static void main(String[] args) throws InterruptedException {
		Tprod p = new Tprod();
		Tprod p2 = new Tprod();
		p.start();
		p.sleep(5000);
		p2.start();

	}

}
