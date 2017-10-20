package Optional;

import java.util.Optional;
import java.util.function.Supplier;

public class ElseOrElseGet {
	static String B(String from) {
	    System.out.println("from " + from + " B()...");
	    return "B";
	}

	public static void main(final String... args) {
	    System.out.println("orElse: " + Optional.of("A").orElse(B("orElse"))); // evaluate B function anyway
	    System.out.println("orElseGet" + Optional.of("A").orElseGet(() -> B("orElseGet"))); //evalute B only not present
	    
	    Optional.ofNullable(methodOne()).orElseGet(methodTwo());
	    		
	}

	private static Supplier<? extends String> methodTwo() {
		return null;
	}

	private static String methodOne() {
		return null;
	}
}
