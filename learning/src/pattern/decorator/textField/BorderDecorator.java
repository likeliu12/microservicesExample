package pattern.decorator.textField;

public class BorderDecorator extends Decorator {
	public BorderDecorator(GraphicalComponent next) {
		super(next);
	}

	@Override
	public void paint() {
		System.out.println("Could have rendered here..");
		super.paint();
		System.out.println("Should probably rendered here..");
	}
}
