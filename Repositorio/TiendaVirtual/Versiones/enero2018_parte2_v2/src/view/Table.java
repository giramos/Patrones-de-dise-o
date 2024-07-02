package view;

import java.util.*;

import model.*;

public abstract class Table {
	// -- Métodos públicos
	// -------------------------------------------------------------

	public void insertRow(CompactDisc cd) {
		rowsCD.add(cd);
	}

	public void insertRow(Book b) {
		rowsBook.add(b);
	}

	public void insertRow(Mobile m) {
		rowsMobile.add(m);
	}

	public void drawTable() {
		computeRowWidths();

		printHeader();
		draw();
		printSeparator();
		System.out.println();

	}

	/**
	 * Si el ancho del texto recibido como parámetro es menor que el deseado añade
	 * espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo: fillWithBlanks("abc", 5) -> "abc " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) {
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo: createDashedLine(5) -> "-----"
	 */
	public String createDashedLine(int ancho) {
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}

	// -- Métodos privados
	// -------------------------------------------------------------

	protected abstract void computeRowWidths();

	protected abstract void printHeader();

	protected abstract void printSeparator();

	protected abstract void draw();

	protected List<CompactDisc> rowsCD = new ArrayList<CompactDisc>();
	protected List<Book> rowsBook = new ArrayList<Book>();
	protected List<Mobile> rowsMobile = new ArrayList<Mobile>();
}
