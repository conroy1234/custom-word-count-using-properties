package threads;

public class Sequence {

	int index=0;
	public int next() {
		synchronized (this) {
			return index++;
		}
		
	}
}
