package concurrent.blockingQueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Random random = new Random();
		try {
			for (String message = queue.take(); !message.equals("DONE"); message = queue
					.take()) {
				System.out.format("MESSAGE RECEIVED: %s%n", message);
				Thread.sleep(random.nextInt(5000));
				Set<String>s = new TreeSet<>();
				s.add(null);
				s.add(null);
				System.out.format("MESSAGE RECEIVED: %s%n", message);

			}
		} catch (InterruptedException e) {
		}
	}
}
