package generic.multiBound;

public class Glass<T extends Juice & Fluid> {
	private T liquid;
	
	public <U extends Juice & Fluid> String getTaste(U something) {
		return something.taste();
	}
}
