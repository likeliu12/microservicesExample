package pattern.decorator.textField;

interface GraphicalComponent {
	public void paint();
	public GraphicalComponent addContent(Object content);
}
