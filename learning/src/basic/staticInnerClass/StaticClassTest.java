package basic.staticInnerClass;

public class StaticClassTest {
	private static int si;
	private int i;
	
	private static class InnerStatic {
		public String ts;
		
		void im() {
			//i = 5; //could not access instance variable
			si =6;
		}
	}
	
	void m1() {
		InnerStatic innerStatic = new InnerStatic();
		innerStatic.ts = "abc";
		
		InnerStatic innerStatic2 = new InnerStatic();
		
		if(innerStatic == innerStatic2) {
			System.out.println("equal");
		}
		else {
			System.out.println("not equal");
		}
		
		Inner inner = new Inner();
		inner.ts = "5";
	}
	
	private class Inner {
		public String ts;
		
		void im() {
			i = 5; //could access instance variable
			si =6;
		}
	}
	
	public static void main(String[] args) {
		StaticClassTest test = new StaticClassTest();
		test.m1();
		Inner inner = test.new Inner();
		InnerStatic innerStatic = new StaticClassTest.InnerStatic();
	}
}
