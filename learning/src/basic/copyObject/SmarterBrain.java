package basic.copyObject;

public class SmarterBrain extends Brain implements Cloneable{
	public SmarterBrain() {
	}

	public Object clone() throws CloneNotSupportedException {
		SmarterBrain another = (SmarterBrain) super.clone();
		// … take care of any deep copies to be made here
		return another;
	}
}
