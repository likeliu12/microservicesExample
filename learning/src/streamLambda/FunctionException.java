package streamLambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionException {
	Map<String, Integer> nameMap = new HashMap<>();
	
	Integer methodWithException(String s) throws Exception {
		if(s.length() == 0) {
			throw new Exception("zero");
		}
		
		return 1;
	}
	
	void origin() {
		//error: Function can't handle exception
		//Function<String, Integer> f = (String s) -> methodWithException(s);
	}
	
	void solution() {
		Function<String, Integer> methodConvertToRuntiome = (String s) -> {
			try {
				return methodWithException(s);
			}
			catch(Exception e) {
				throw new RuntimeException("run time");
		}};

		Function<String, Integer> f = methodConvertToRuntiome;
	}
	

}
