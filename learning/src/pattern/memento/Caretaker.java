package pattern.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	private List<Memento> statesList = new ArrayList<>();

	public void addMemento(Memento m) {
		statesList.add(m);
	}

	public Memento getMemento(int index) {
		return statesList.get(index);
	}
}
