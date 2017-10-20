package basic.copyObject;

public class Driver {
	public static void play(Person p) {
		Person another = (Person) p.clone();
		System.out.println(p);
		System.out.println(another);
	}

	public static void main(String[] args) {
		Person sam = new Person(new Brain(), 1);
		play(sam);
		SkilledPerson bob = new SkilledPerson(new SmarterBrain(), 1, "Writer");
		play(bob);
	}
}
