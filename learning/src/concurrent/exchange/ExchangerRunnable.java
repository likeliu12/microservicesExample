package concurrent.exchange;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {

	Exchanger<String> exchanger = null;
	String object = null;

	public ExchangerRunnable(Exchanger<String> exchanger, String object) {
		this.exchanger = exchanger;
		this.object = object;
	}

	public void run() {
		try {
			Object previous = this.object;

			this.object = this.exchanger.exchange(this.object); //Waits for another thread to arrive at this exchange point 

			System.out.println(Thread.currentThread().getName() + " exchanged "
					+ previous + " for " + this.object);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();

		ExchangerRunnable exchangerRunnable1 =
		        new ExchangerRunnable(exchanger, "ABC");

		ExchangerRunnable exchangerRunnable2 =
		        new ExchangerRunnable(exchanger, "XYZ");

		new Thread(exchangerRunnable1).start();
		new Thread(exchangerRunnable2).start();
	}
}