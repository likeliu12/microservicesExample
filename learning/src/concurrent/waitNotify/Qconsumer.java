package concurrent.waitNotify;

public class Qconsumer implements Runnable {
	Q q;

	Qconsumer(Q q) {
		this.q = q;
	}

	public void run() {
		while (true) {
			q.get();
		}
	}
}
