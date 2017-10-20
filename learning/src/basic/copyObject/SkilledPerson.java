package basic.copyObject;

public class SkilledPerson extends Person {
	private String theSkills;

	public SkilledPerson(Brain aBrain, int theAge, String skills) {
		super(aBrain, theAge);
		theSkills = skills;
	}

	protected SkilledPerson(SkilledPerson another) {
		super(another);
		theSkills = another.theSkills;
	}

	public Object clone() {		
		return new SkilledPerson(this);
	}

	public String toString() {
		return "SkilledPerson: " + super.toString();
	}
}
