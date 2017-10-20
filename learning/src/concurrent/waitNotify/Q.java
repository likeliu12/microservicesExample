package concurrent.waitNotify;

class Q {
	int n;
	boolean valueSet = false;

	synchronized int get() {
		while (!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		System.out.println(Thread.currentThread().getName() + " got: " + n);
		valueSet = false;
		notifyAll();
		return n;
	}

	synchronized void put(int n) {
		while (valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		this.n = n;
		valueSet = true;
		System.out.println(Thread.currentThread().getName() + " put: " + n);
		notifyAll();
	}
}
