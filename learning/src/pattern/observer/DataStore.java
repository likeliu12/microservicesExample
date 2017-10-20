package pattern.observer;

import java.util.Observable;

public class DataStore extends Observable {
	private String data;

	public DataStore(String data) {
		this.data = data;
	}
	public void setData(String data) {
		if (!this.data.equals(data)) {
			this.data = data;

			setChanged();
			notifyObservers();
		}
	}
}
