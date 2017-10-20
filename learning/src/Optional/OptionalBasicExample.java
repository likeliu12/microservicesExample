package Optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalBasicExample {
	public static void main(String[] args) {
		basicTest();
		optionCallMethodAndReturn();
		optionCallConsumer();

		mapFlatMap();
		optionalStream();
	}

	private static void mapFlatMap() {
		Optional.of("abc").map(OptionalBasicExample::buildNull)
				.map(s -> s + ("abc")).ifPresent(System.out::println);

		Optional.of("abcccc").map(s -> s + ("abc"))
				.ifPresent(System.out::println);

		Optional.of("abc").map(OptionalBasicExample::buildNull)
				.map(s -> s + ("abc")).orElseGet(() -> buildNull("def"));
	}

	private static String buildNull(String s) {
		return null;
	}

	private static void optionalStream() {
		List<String> strs = Arrays.asList(null, "", "abc", "def", "fdsfd");

		Optional<String> os = strs
				.stream()
				// .filter(s -> !(s == null || s.isEmpty()))
				.map(Optional::ofNullable)
				.flatMap(
						o -> o.isPresent() ? Stream.of(o.get()) : Stream
								.empty()) // empty string is present
				.findFirst();

		System.out.println("os " + os.get());
	}

	private static void optionCallConsumer() {
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		List<String> things = new ArrayList<>();

		// return boolean
		if (gender.isPresent()) {
			System.out.println("Value available.");
		} else {
			System.out.println("Value not available.");
		}

		// consumer
		gender.ifPresent(g -> System.out
				.println("In gender Option, value available."));

		// condition failed, no output print
		emptyGender.ifPresent(g -> System.out
				.println("In emptyGender Option, value available."));
	}

	private static void optionCallMethodAndReturn() {
		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();

		System.out.println("nonEmptyGender.map(String::toUpperCase) "
				+ nonEmptyGender.map(String::toUpperCase));
		System.out.println("emptyGender.map(String::toUpperCase) "
				+ emptyGender.map(String::toUpperCase));

		Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional
				.of("male"));
		System.out
				.println("optional of optional   :: " + nonEmptyOtionalGender);
		System.out.println("map of map     :: "
				+ nonEmptyOtionalGender.map(gender -> gender
						.map(String::toUpperCase)));
		System.out.println("flat of map "
				+ nonEmptyOtionalGender.flatMap(gender -> gender
						.map(String::toUpperCase)));

	}

	private static void basicTest() {
		Optional<String> gender = Optional.of("MALE");
		String answer1 = "Yes";
		String answer2 = null;
		Optional<String> answer3 = Optional.empty();

		System.out.println("gender Non-Empty Optional:" + gender);
		System.out.println("gender.get() Non-Empty Optional: Gender value : "
				+ gender.get());
		System.out.println("Empty Optional: " + Optional.empty());

		System.out.println("Optional.ofNullable(answer1): "
				+ Optional.ofNullable(answer1));
		System.out.println("Optional.ofNullable(answer2): "
				+ Optional.ofNullable(answer2));

		System.out.println("answer3.length: " + answer3.map(String::length));
		// java.lang.NullPointerException
		// System.out.println("Optional.of(answer2): " + Optional.of(answer2));

		// System.out.println("answer2.length: " +answer2.length);

	}
}
