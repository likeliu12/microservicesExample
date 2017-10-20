package lambda.methodRef;

public class Utils {
	public static String transform(String s, StringFunction f) {
		return f.applyFunction(s);
	}
	public static String makeExciting(String s) {
		return s + "!!";
	}
}
