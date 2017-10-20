package basic.varargs;

import java.util.Arrays;

public class Test {
	void printStringList(String... s) { // compiler String[]
		for (String str : s) {
			System.out.println(str);
		}
	}

	@SafeVarargs
	// suppresses warning only
	final <T> void printList(T... s) {// compiler Object[]
		for (T str : s) {
			System.out.println(str);
		}
	}

	@SafeVarargs
	// suppresses warning only
	final <T> void doSomething(T... s) { // bad for it could be modified to
											// different type. heap pollution.
		Object[] os = s;
		os[0] = new Integer(3);

		os[1] = new String("abc");
	}
	@SafeVarargs
	final static <T> T[] asArray(T... args) {
		return args; //return Object[]
	}

	final static <T> T[] arrayOfTwo(T a, T b) {
		return asArray(a, b);
	}

	public static void main(String[] args) {
		Test test = new Test();
		test.printStringList("abc", "def");
		test.printList("fds", "def");
		Arrays.asList("a");// use it could be good for it include @SafeVarargs.
		
		//can not cast Object[] to String[]
		String[] bar = arrayOfTwo("hi", "mom");
	}
}
