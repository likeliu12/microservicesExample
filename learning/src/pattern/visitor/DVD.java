package pattern.visitor;

public class DVD implements Visitable{
	private double weight;
	public DVD(double weight) {
		this.weight = weight;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	public double getWeight() {
		return weight;
	}	
}
