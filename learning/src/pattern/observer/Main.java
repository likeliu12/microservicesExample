package pattern.observer;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		main.test();
	}
	
	void test() {
		Client c1 = new Client("c1");
		Client c2 = new Client("c2");
		
		DataStore dataStore = new DataStore("wait");
		dataStore.addObserver(c1);
		dataStore.addObserver(c2);
		
		//no data change
		System.out.println("wait -> wait");
		dataStore.setData("wait");
		
		//change data
		System.out.println("wait -> start");
		dataStore.setData("start");
	}
}
