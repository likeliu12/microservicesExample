package stream.sideEffects;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class StatefulExample {
	public static void main(String[] args) {
		statefull();
		System.out.println("*********");
		stateless();

	}

	private static void stateless() {
		for (int i = 0; i < 5; i++) {
			IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
			int sum = stream.parallel().distinct().sum();
			System.out.println("stateless " + sum);
		}

	}

	private static void statefull() {
		for (int i = 0; i < 5; i++) {

			Set<Integer> seen = new HashSet<>(); //should use ConcurrentHashMap.newKeySet()
			IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
			int sum = stream.parallel().map(
			// stateful behavioral parameter.
					e -> {
						if (seen.add(e))
							return e;
						else
							return 0;
					}).sum();

			System.out.println("statefull " + sum);
		}
	}
}
