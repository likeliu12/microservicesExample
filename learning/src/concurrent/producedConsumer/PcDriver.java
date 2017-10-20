package concurrent.producedConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class PcDriver {
	public static void main(String args[]) {
		final BlockingQueue<String> q = new SynchronousQueue  <String>();
		
		Producer p = new Producer("p1", q);
		Consumer c1 = new Consumer("c1", q);
		Consumer c2 = new Consumer("c2", q);
		
		new Thread(p).start();

		new Thread(c1).start();
		new Thread(c2).start();
	}
}
