package concurrent.pipedinoutio;

import java.io.InputStream;
import java.io.OutputStream;

class ReadThread extends Thread implements Runnable {

	  InputStream pi = null;
	  OutputStream po = null;    
	  String process = null;

	  ReadThread( String process, InputStream pi, OutputStream po) {
	    this.pi = pi;    this.po = po;    this.process = process;  }

	  public void run() {
	    int ch;    byte[] buffer = new byte[512];    int bytes_read;
	    try { 
	        for(;;) {
	            bytes_read = pi.read(buffer);
	            if (bytes_read == -1) { return; }
	            po.write(buffer, 0, bytes_read);
	        }
	    } catch (Exception e) {  e.printStackTrace(); 
	    } finally {  }
	  }

	}