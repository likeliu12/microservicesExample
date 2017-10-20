package pattern.visitor;

public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		m.test();
	}
	
	void test() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Book(4.23, 2.0));
		cart.addItem(new DVD(3));
		
		double total = cart.calculatePostage();
		System.out.println("total is " + total);
	}
}
