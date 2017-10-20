package stream.terminal;

public class Person {
	City city;
	String name;
	int age;
	
	public Person(City city, String name, int age) {
		this.city = city;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [city=" + city + ", name=" + name + ", age=" + age + "]";
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
