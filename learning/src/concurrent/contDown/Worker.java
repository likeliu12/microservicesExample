package concurrent.contDown;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable {
	   private final CountDownLatch startSignal;
	   private final CountDownLatch doneSignal;
	   Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
	      this.startSignal = startSignal;
	      this.doneSignal = doneSignal;
	   }
	   public void run() {
	      try {
	        startSignal.await();
	        doWork();
	        System.out.println("a thread complete");
	        doneSignal.countDown();
	      } catch (InterruptedException ex) {} // return;
	   }

	   void doWork() throws InterruptedException {
		   Thread.sleep(1000);
	   }
	 }
