package concurrent.producedConsumer;

import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
	String name;
	 private final BlockingQueue<String> q;

	Consumer(String name, BlockingQueue<String> q) {
		this.name = name;
		this.q = q;
	}

	public void run() {
		while (true) {
			try {
				String msg = q.take();
				
				System.out.println(name + " " + msg);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
