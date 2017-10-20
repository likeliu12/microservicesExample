package concurrent.pipedinoutio;

import java.io.FileOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class PipeDriver {

	public static void main(String[] args) {
		try {
			int ch;
			while (true) {
				PipedInputStream writeIn = new PipedInputStream();
				PipedOutputStream readOut = new PipedOutputStream(writeIn);

				ReadThread rt = new ReadThread("reader", System.in, readOut);
				ReadThread wt = new ReadThread("writer", writeIn, System.out);

				rt.start();
				wt.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}