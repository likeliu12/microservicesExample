package pattern.visitor;

interface Visitor {
	public void visit(Book book);
	public void visit(DVD dvd);
}
