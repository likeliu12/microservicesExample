package pattern.command;

//Receiver
public class Light {
	private boolean on;

	public void switchOn() {
		on = true;
		System.out.println("Light ON");
	}

	public void switchOff() {
		on = false;
		System.out.println("Light OFF");
	}
}
