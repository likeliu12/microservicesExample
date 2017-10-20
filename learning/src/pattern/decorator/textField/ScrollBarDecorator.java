package pattern.decorator.textField;

public class ScrollBarDecorator extends Decorator {

	public ScrollBarDecorator(GraphicalComponent next) {
		super(next);
	}
	@Override
	public void paint() {
		System.out.println("Render the scrool bar....");
		super.paint();
		System.out.println("end Render the scrool bar....");
		
	}
}
