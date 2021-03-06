package pattern.decorator.textField;

public abstract class Decorator implements GraphicalComponent{
	private GraphicalComponent next;
	public Decorator(GraphicalComponent next) {
		this.next = next;
	}
	
	@Override
	public void paint() {
		next.paint();
	}

	@Override
	public GraphicalComponent addContent(Object content) {
		return this;
	}

}
