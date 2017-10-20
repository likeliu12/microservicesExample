package stream.intermediate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Examples {
	static List<Book> lib = Arrays.asList(new Book("book1", new Author("John",
			31, Gender.MALE)), new Book("book1", new Author("Doe", 41,
			Gender.FEMALE)), new Book("book1", new Author("Chris", 51,
			Gender.MALE)), new Book("book1", new Author("Sam", 31,
			Gender.FEMALE)));

	public static void main(String[] strs) {
		basicTest();
		mapTest();
		hashMapTest();
	}

	private static void hashMapTest() {
        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        
        String hashMapResult = HOSTING.entrySet().stream()
                .filter(map -> !("aws.amazon.com".equals(map.getValue())))
                .map(map -> map.getValue())
                .collect(Collectors.joining(";")); 
		System.out.println("hashMapResult: " + hashMapResult);        
	}

	private static void mapTest() {
		List evens = Arrays.asList(2, 4, 6); 
		List odds = Arrays.asList(3, 5, 7);
		List primes = Arrays.asList(2, 3, 5, 7, 11); 
		
		List numbers = Stream.of(evens, odds, primes) 
				.flatMap(list -> list.stream()) 
				.distinct()
				.collect(Collectors.toList()); 
		System.out.println("flattend list: " + numbers);

		numbers = Arrays.asList(evens, odds, primes) //list of list
				.stream() //stream of list
				//convert list to stream, will be stream of stream of Integer
				//then flat a stream, will be steam of Integer
				.flatMap(List::stream) 
				.distinct()
				.collect(Collectors.toList()); 
		System.out.println("flattend list: " + numbers);

		String[] arrayOfWords = {"Stack", "OOOVVVER"};
		
		List<String> stackOver = Arrays.stream(arrayOfWords)
		.map(s->s.split(""))
		.flatMap(Arrays::stream)
		.map(String::toUpperCase)
		.distinct()
		.collect(Collectors.toList());
		
		System.out.println(stackOver);
		
	}
	
 	private static void basicTest() {
		List<String> names = lib.stream().map(book -> book.getAuthor())
				.filter(author -> author.getAge() >= 40).limit(2)
				.map(Author::getName).map(String::toUpperCase)
				.collect(Collectors.toList());

		System.out.println("names " + names);

		List<Integer> ageList = lib.stream().map(Book::getAuthor)
				.map(Author::getAge).distinct().collect(Collectors.toList());
		System.out.println("ageList " + ageList);

		Optional<Integer> maxAge = lib.stream().map(Book::getAuthor)
				.filter(a -> a.getGender() == Gender.FEMALE)
				.map(Author::getAge).max(Integer::compareTo);
		System.out.println("maxAge " + maxAge.get());
	}
}
