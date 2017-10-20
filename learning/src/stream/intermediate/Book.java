package stream.intermediate;

public class Book {
	String title;
	Author author;
	
	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuther(Author author) {
		this.author = author;
	}
}
