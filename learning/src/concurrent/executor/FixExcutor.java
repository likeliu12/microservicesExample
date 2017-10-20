package concurrent.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FixExcutor {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(4);
		
		ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("Starting");
		// Start the threads.
		es.execute(new MyThread(cdl, "A"));
		es.execute(new MyThread(cdl, "B"));
		es.execute(new MyThread(cdl, "C"));
		es.execute(new MyThread(cdl, "D"));
		
		es.shutdown();
		//wait for finish or use CountDownLatch
//		try {
//			es.awaitTermination(0, TimeUnit.SECONDS);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			cdl.await();
			
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		
		System.out.println("Done");
		
		
	}
}
