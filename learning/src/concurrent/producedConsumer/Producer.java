package concurrent.producedConsumer;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
	String name;
	private final BlockingQueue<String> q;

	Producer(String name, BlockingQueue<String> q) {
		this.name = name;
		this.q = q;
	}

	public void run() {
		int i = 0;
		while (true) {
			try {
				q.put("message from producer " + name + "#" + i++);
				System.out.println(q.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
