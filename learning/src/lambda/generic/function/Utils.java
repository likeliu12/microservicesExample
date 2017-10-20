package lambda.generic.function;

import java.util.function.Function;

public class Utils {
	public static <T, R> R transform(T t, Function<T, R> f) {
		return f.apply(t);
	}
	
	public static <T> String makeExciting(T t) {
		return t.toString() + "!!";
	}
}
