package pattern.decorator.textField;

public class Main {
	public static void main(String[] args){
		GraphicalComponent tf = constructSomeString();
		
		//static added
		tf = new BorderDecorator(tf);
		tf.paint();
	}
	
	public static GraphicalComponent constructSomeString() {
		GraphicalComponent tf = new TextField();
		
		tf = tf.addContent("one");
		tf = tf.addContent("two");
		tf = tf.addContent("three");
		tf = tf.addContent("four");
		
		return tf;
	}
}
