package lambda.generic;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Driver {
	public static void main(String[] args) {

		Predicate <Integer>p = e -> e > 2;
		boolean pass = p.test(5);
		
		//assign lambda
		Consumer<Employee> c = e -> {e.setSalary(e.getSalary() * 1.1);
										System.out.println("Consumer new salary: " + e.getSalary());};
		Employee employee = new Driver().new Employee();
		c.accept(employee);
		
		Supplier<Double> s = () -> new Double(10);
		Double d = s.get();
		System.out.println("supplier: " + d);
		
		Function<Integer, Double> f = e -> 1.0d * e;
		d = f.apply(5);
		
		//assign method reference
		Function<String, String> f2 = String::toUpperCase;
		String str = f2.apply(new String("abc"));
		
		BinaryOperator<Integer>b = (e1, e2) -> e1 + e2;
		Integer sum = b.apply(3, 2);
		
		Driver driver = new Driver();
		driver.assignMethodName(driver);
	}
	
	void  assignMethodName(Driver d) {
		Consumer<Employee> c1 = d::randomSupplier;
		
		Employee employee = new Driver().new Employee();
		c1.accept(employee);	
		System.out.println("assignMethodName new salary: " + employee.getSalary());
		}
	
	void randomSupplier(Employee e) {
//		Supplier[] suppliers = {
//				Driver::new,
//				String::new,
//				() -> new Driver().new Employee(),
//				() -> {return new Integer(12);}
//		};
		e.setSalary(e.getSalary() + 1000); 
			
	}
	void someMethod(String s) {
		
	}
	void someMethod(String ... strs) {
		
	}
	
	class Employee {
		String name;
		Double salary = 2000.0;
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}			
		
	}

}
