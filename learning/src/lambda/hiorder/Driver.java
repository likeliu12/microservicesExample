package lambda.hiorder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Driver {
	private Employee[] employees = { new Employee("John", "Doe", 1, 234_567),
			new Employee("Jane", "Doe", 2, 333_333),
			new Employee("Sammy", "Smith", 3, 99_000),
			new Employee("Sally", "Smith", 4, 99_000) };

	Predicate<Employee> buildPredicate(double lowerBound) {
		return e -> e.getSalary() >= lowerBound;
	}

	public static void main(String[] args) {
		Driver d = new Driver();
		d.testFunctionReturnPredicate();
		d.testLambdaPredicate();
	}

	void testFunctionReturnPredicate() {
		List<Employee> richEmployees1 = allMatches(employees,
				buildPredicate(200_000));
		System.out.printf(
				"Rich employees [via method that returns Predicate]: %s.%n",
				richEmployees1);
	}

	void testLambdaPredicate() {
		Function<Integer, Predicate<Employee>> makeIsRichPredicate = salaryLowerBound -> (e -> e
				.getSalary() >= salaryLowerBound);

		//makeIsRichPredicate.apply(200_000) return e->e.getSalary() >= 200_000
		List<Employee> richEmployees2 = allMatches(employees,
				makeIsRichPredicate.apply(200_000));
		System.out.printf(
				"Rich employees [via Function that returns Predicate]: %s.%n",
				richEmployees2);
	}

	<T> List<T> allMatches(T[] employees2, Predicate<T> predicate) {
		List<T> matches = new ArrayList<>();
		for (T possibleMatch : employees2) {
			if (predicate.test(possibleMatch)) {
				matches.add(possibleMatch);
			}
		}
		return (matches);
	}
}
