package threads;

public class WorkExecuter {

	public static void main(String[] args) {
		Sequence sequesnc = new Sequence();
		Sequence sequesnc1 = new Sequence();
		new Work("read-3", sequesnc).start();
		new Work("read-4", sequesnc1).start();
	}

}
