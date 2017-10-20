package stream.terminal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Examples {
	static Person jon = new Person(City.Tulsa, "Joh", 42);
	static Person amy = new Person(City.Athens, "Amy", 21);
	static Person bill = new Person(City.Londo, "Bill", 33);
	static Person eric = new Person(City.Athens, "Eric", 33);

	static List<Person> people = Arrays.asList(jon, amy, bill, eric);
	
	public static void main(String[] strs) {
		Examples examples = new Examples();
	
		examples.testReduction();
		examples.testForeach();
		examples.testCollection();
	}
	
	private void testForeach() {
		IntStream.range(1, 10).forEach(System.out::println); //side effect		
	}

	private void testReduction() {
		Integer[] vals = new Integer[101];
		Arrays.setAll(vals, i -> i);
		
		int sum = Arrays.stream(vals)
				.reduce(0, (a, b) -> a + b);
		
		sum = Arrays.stream(vals)
				.reduce((a, b) -> a + b).get();
		
		sum = Arrays.stream(vals).parallel().reduce(0, Integer::sum);
		
		//stream of
		Integer i = Stream.of(vals).findFirst().get();
	   
	}
	
	private void testCollection() {
		Set<Integer> ages = people.stream().map(Person::getAge).collect(Collectors.toSet());
		System.out.println("ages" + ages);
		
		 List<String> names = people.stream()
				 .collect(() -> new ArrayList<>(), (c, e) -> c.add(e.getName()), (c1, c2) -> c1.addAll(c2));
		System.out.println("names " + names);

		Map<Integer, List<Person>> peopleByAge = people.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("peopleByAge" + peopleByAge);
		
		Map<Integer, List<String>> namesByAge = people.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));
		System.out.println("namesByAge" + namesByAge);
		
		Map<Integer, Long> populationByAge = people.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
		System.out.println("populationByAge"+ populationByAge);
		
		List<City> citiesWithMoreThanOnePerson = people.stream()
				.collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))    //Map<City, Long>
				.entrySet().stream()
				.filter(e -> e.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("citiesWithMoreThanOnePerson" + citiesWithMoreThanOnePerson);
		
		int mostPopulatedAge = people.stream()
				.collect(Collectors.groupingBy(Person::getAge, Collectors.counting())) //Map<Integer, Long>
				.entrySet().stream()
				.max((e1, e2) -> Long.compare(e1.getValue(), e2.getValue())).get().getKey();
		System.out.println("mostPopulatedAge" + mostPopulatedAge);

		Map<City, String> namesGroupByCity = people.stream()
				.collect(Collectors.groupingBy(Person::getCity, Collectors.mapping(Person::getName, Collectors.joining(","))));
		System.out.println("namesGroupByCity" + namesGroupByCity);
		
		Stream<String> words = Stream.of("a", "b", "a", "c");
		Map<String, Integer> wordsCount = words.collect(Collectors.toMap(s -> s, s -> 1,
		                                                      (i, j) -> i + j));
		System.out.println(wordsCount);
		
		Map<String, Integer> nameAgeMap = people.stream()
		.collect(Collectors.toMap((Person p) -> p.getName(), p -> p.getAge()));
		
		System.out.println(nameAgeMap);
		
	}
}
