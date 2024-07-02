package model.adapter;

import model.Articulo;
import model.Book;

public class AdapterBook implements Articulo {

	private Book libro;

	public AdapterBook(Book b) {
		this.libro = b;
	}
	@Override
	public String etiquetaUno() {
		// TODO Auto-generated method stub
		return libro.getTitle();
	}

	@Override
	public String etiquetaDos() {
		// TODO Auto-generated method stub
		return libro.getAuthor();
	}

}
