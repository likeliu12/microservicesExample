package lambda.methodRef;

import java.util.Arrays;

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
		
		StringFunction stringFunction = new StringFunction() {
			
			@Override
			public String applyFunction(String s) {
				
				return s.toUpperCase();
			}
		};
		//class instance method
		//(obj, args) -> obj.instanceMethod(args)
		//ObjectType::instanceMethod
		result = Utils.transform(tString, stringFunction); // without parm
		result = Utils.transform(tString, obj -> obj.toUpperCase()); // without parm
		result = Utils.transform(tString, String::toUpperCase);	 //without parm
		
		String[] stringArray = { "Barbara", "James", "Mary", "John",
			    "Patricia", "Robert", "Michael", "Linda" };
			Arrays.sort(stringArray, String::compareToIgnoreCase);
			Arrays.sort(stringArray, (a, b) -> a.compareToIgnoreCase(b));
	}
}
