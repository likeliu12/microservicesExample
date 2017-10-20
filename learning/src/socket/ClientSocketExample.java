package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketExample {
	public static void main(String[] args) {
		try {

			InetAddress host = InetAddress.getLocalHost();
			Socket socket = new Socket(host.getHostName(), 7777);

			ObjectOutputStream oos = new ObjectOutputStream(
					socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(
					socket.getInputStream());

			int i = 5;
			while (--i > 0) {
				System.out.println("Message: to server ");
				oos.writeObject("Hello Server...");

				String message = (String) ois.readObject();
				System.out.println("Message: from server " + message);
			}

			ois.close();
			oos.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
