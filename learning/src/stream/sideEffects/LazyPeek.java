package stream.sideEffects;

import java.util.stream.IntStream;

public class LazyPeek {
	public static void main(String[] args) {
	    IntStream stream = createAStreamAndPerformSomeSideEffectWithPeek();
	    System.out.println("Second. I should be the second group of prints");
	    consumeTheStream(stream);
	}

	private static IntStream createAStreamAndPerformSomeSideEffectWithPeek() {
	    return IntStream.of(1, 2, 3)
	            .peek(number -> System.out.println(String.format("First. My number is %d", number)))
	            .map(number -> number + 1);
	}

	private static void consumeTheStream(IntStream stream) {
	    stream.filter(number -> number % 2 == 0)
	            .forEach(number -> System.out.println(String.format("Third. My number is %d", number)));
	}
}
