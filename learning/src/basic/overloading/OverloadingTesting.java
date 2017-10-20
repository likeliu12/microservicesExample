package basic.overloading;

public class OverloadingTesting {
	static void s1() {
		
	}
	static void s1(String s) {
		
	}
	void s1(int i) {}
	public void m1() {
		System.out.println("0");
	}
	
	public int m1(int i) {
		return 1;
	}
	
	//accessor
	private int m1(String s) {
		return 2;
	}
	
	//autoboxing
	private int m1(Integer i) {
		return 3;
	}
	
	//promotion int vs long
	public int m1(long l) {
		return 4;
	}
	
	static int m1(Long l) {
		return 5;
	}
	
	//exception
	public int m1(double d) throws Exception {
		throw new Exception();
	}
	
	public static void main(String[] args) {
		OverloadingTesting overloadingTesting = new OverloadingTesting();
		
		System.out.println(overloadingTesting.m1(1));
		System.out.println(overloadingTesting.m1("1"));
		System.out.println(overloadingTesting.m1(new Integer(1)));
		System.out.println(overloadingTesting.m1(1L));

		System.out.println(m1(new Long(1)));

		try {
			System.out.println(overloadingTesting.m1(1d));
		} catch (Exception e) {
			System.out.println(6);
		}
		
	}
}
