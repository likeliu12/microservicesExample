package lambda.basic;

public class FunctionInterfaceClient{

	public Double calculate(Double v1, Double v2, FunctionInterface funcInt) {
		return funcInt.calculate(v1, v2);
	}

}
