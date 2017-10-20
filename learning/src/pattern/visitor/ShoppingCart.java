package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Visitable> items = new ArrayList<Visitable>();

	public void addItem(Visitable v) {
		items.add(v);
	}
	public double calculatePostage() {
		PostageVisitor visitor = new PostageVisitor();
		for (Visitable item : items) {
			item.accept(visitor);
		}
		return visitor.getTotalPostage();
	}
}
