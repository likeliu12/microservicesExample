package pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Client implements Observer{
	String clientName;

	public Client(String clientName) {
		this.clientName = clientName;
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(clientName + " receive data change notification");
	}
}
