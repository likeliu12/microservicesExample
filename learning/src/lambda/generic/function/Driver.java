package lambda.generic.function;

import java.util.Arrays;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		//constructor
		//(args) -> new ClassName(args)
		//ClassName::new
		String tString = Utils.transform("test", String::new);
		
		//static method
		//(args) -> Class.staticMethod(args)
		//Class::staticMethod
		String result = Utils.transform(tString, Utils::makeExciting);
		
		//object method	 
		//(args) -> obj.instanceMethod(args)
		//obj::instanceMethod
		result = Utils.transform(tString, tString::concat);
		
		//class instance method
		//(obj, args) -> obj.instanceMethod(args)
		//ObjectType::instanceMethod
		result = Utils.transform(tString, obj -> obj.toUpperCase());
		result = Utils.transform(tString, String::toUpperCase);	
		
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda" };
			Arrays.sort(stringArray, String::compareToIgnoreCase);
			Arrays.sort(stringArray, (a, b) -> a.compareToIgnoreCase(b));
			
		//List type
		List<String> words = Arrays.asList("hi", "bye");
		int size = Utils.transform(words,  List::size);
	}
}
