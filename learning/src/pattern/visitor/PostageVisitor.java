package pattern.visitor;

public class PostageVisitor implements Visitor {
	private double totalPostageForCart;

	@Override
	public void visit(Book book) {
		if (book.getPrice() < 10.0) {
			totalPostageForCart += book.getWeight() * 2;
		}
		System.out.println("add book ");
		System.out.println("sub total " + totalPostageForCart);
	}

	public void visit(DVD dvd) {
		totalPostageForCart += dvd.getWeight() * 5;
		System.out.println("add DVD ");
		System.out.println("sub total " + totalPostageForCart);
	}

	public double getTotalPostage() {
		return totalPostageForCart;
	}
}
