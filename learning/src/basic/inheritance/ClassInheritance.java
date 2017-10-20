package basic.inheritance;

class Parent {
	public Parent() {
		System.out.println("in Parent()");
	}
	
	public Parent(String s) {
		System.out.println("in Parent with String");
	}
}
public class ClassInheritance extends Parent{
	public ClassInheritance(String s) {
		super(s);
	}
	public static void main(String[] args) {
		ClassInheritance classInheritance = new ClassInheritance("string");
	}
}
