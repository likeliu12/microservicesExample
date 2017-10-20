package concurrent.waitNotify;

public class PcDriver {
	public static void main(String args[]) {
		Q q = new Q();
		new Thread(new Qproducer(q)).start();
		new Thread(new Qconsumer(q)).start();

		System.out.println("Press Control-C to stop.");
	}
}
