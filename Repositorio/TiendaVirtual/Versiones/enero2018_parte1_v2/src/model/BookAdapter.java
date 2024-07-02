package model;

public class BookAdapter implements Articulo {
	Book libro;
	public BookAdapter(Book b) {
		this.libro = b;
	}
	@Override
	public String getCadena1() {
		// TODO Auto-generated method stub
		return libro.getTitle();
	}

	@Override
	public String getCadena2() {
		// TODO Auto-generated method stub
		return libro.getAuthor();
	}

}
