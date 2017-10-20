package basic.copyObject;

public class Brain implements Cloneable {
	public Brain() {
	}
	public Object clone() throws CloneNotSupportedException {
		Brain brain =(Brain) super.clone();
		//deep copy if necessary
		return brain;
	}
}
