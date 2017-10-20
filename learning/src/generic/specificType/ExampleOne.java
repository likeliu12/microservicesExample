package generic.specificType;

//only class level for non static usuage
public class ExampleOne<T> extends Parent<T>{ //T should match
	private T value;
	//not working on static
	//static T v2;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	//method level for static or non static
	public <Z> Z noOp(Z val) {
		T t;
		return val;
	}
	
	public static <E, Z> Z noOp2(E val, Z update) {
		return update;
	}
	
	public static void main(String[] strs) {
		ExampleOne<Integer> exampleOne = new ExampleOne<Integer>();
		exampleOne.setValue(new Integer(4));
		System.out.println(exampleOne.getValue());
		
		Integer s = noOp2(new String(), new Integer(3));
	}
}
