package lambda.basic;
@FunctionalInterface
interface FunctionInterface {
	//FunctionalInterface only allow single abstract method
	Double calculate(Double v1, Double v2);
	static Double add2(Double v1, Double v2){
		return 2d;
	}
	static Double add3(Double v1, Double v2) {
		return 3d;
	}
	default Double addDefault(Double v1, Double v2){ 
		return v1 + v2;
	}
	
	default Double subDefault(Double v1, Double v2) {
		return add2(v1, v1);
	}
}
