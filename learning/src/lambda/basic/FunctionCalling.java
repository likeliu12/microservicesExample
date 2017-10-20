package lambda.basic;

public class FunctionCalling {
	public static void main(String[] args) {
		FunctionCalling calling = new FunctionCalling();
		FunctionInterfaceClient client = new FunctionInterfaceClient();
		
		//lambda passed for calculate method
		System.out.println(client.calculate(6d, 3d, (v1, v2) -> v1 + v2));
		System.out.println(client.calculate(6d, 3d, (v1, v2) -> v1 * v2));
		System.out.println(client.calculate(6d, 3d, (v1, v2) -> v1 / v2));
		
		//client.calculate(6d, 3d, System.out::println);
	}
}
