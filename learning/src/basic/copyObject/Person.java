package basic.copyObject;

public class Person implements Cloneable{
	private int age;
	private final Brain brain;
	
	public Person(Brain aBrain, int theAge)
	{
		brain = aBrain; 
		age = theAge;
	}
	protected Person(Person another)
	{
		Brain refBrain = null;
		try
		{
			refBrain = (Brain) another.brain.clone();
		}
		catch(CloneNotSupportedException e) {}
		brain = refBrain;
		age = another.age;
	}
 	public String toString()
	{
		return "This is person with " + brain;
	}
 	public Object clone()
	{
		return new Person(this);
	}
}
