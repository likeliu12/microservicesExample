package lambda.hiorder;

public class Employee {
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	String firstName;
	String lastName;
	int id;
	double salary;

	public Employee(String firstName, String lastName, int id, double salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.salary = salary;
	}
	
	public String toString() {
		return firstName + " " + lastName + " " + salary;
	}
}
