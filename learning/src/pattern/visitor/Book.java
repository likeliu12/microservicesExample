package pattern.visitor;

class Book implements Visitable {
	private double price;
	private double weight;
	public Book(double price, double weight) {
		super();
		this.price = price;
		this.weight = weight;
	}
	@Override
	public void accept(Visitor vistor) {
		vistor.visit(this);
	}
	public double getPrice() {
		return price;
	}
	public double getWeight() {
		return weight;
	}
}
