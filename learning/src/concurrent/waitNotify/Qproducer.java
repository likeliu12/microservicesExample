package concurrent.waitNotify;

public class Qproducer implements Runnable {
	Q q;

	Qproducer(Q q) {
		this.q = q;
	}

	public void run() {
		int i = 0;
		while (true) {
			q.put(i++);
		}
	}
}
