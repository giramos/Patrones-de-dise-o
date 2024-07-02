package view;

import model.Book;
import model.CompactDisc;
import model.Mobile;

public class RandomTable extends Table {

	private int longestTitle = 0;
	private int longestPropietario = 0;
	private int longestInfo = 0;

	@Override
	protected void printHeader() {

		printSeparator();
		printRow("Título", "Propietario", "Información");
		printSeparator();

	}

	void printRow(String title, String autor, String editorial) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(autor, longestPropietario));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(editorial, longestInfo + 3));
		System.out.println(" |");

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestPropietario + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestInfo + 5));
		System.out.println("+");
	}

	@Override
	protected void draw() {
		// D) Mostrar los discos, móviles y libros en una tabla de 3 columnas
		// (que ponga "Título", "Propietario" e "Información" en la cabecera)
		// - Los móviles muestran su modelo, marca y la tercera columna en blanco.
		// - Los discos muestran su título, artista y género en cada columna.
		// - Los libros muestran su título, autor e idioma
		for (Mobile m : rowsMobile)
			printRow(m.getModel(), m.getBrand(), "");
		for (CompactDisc c : rowsCD)
			printRow(c.getTitle(), c.getArtist(), c.getGenre());
		for (Book b : rowsBook)
			printRow(b.getTitle(), b.getAuthor(), b.getLanguage());

	}

	@Override
	protected void computeRowWidths() {
		longestTitle = longestPropietario = longestInfo = 0;
		for (Mobile m : rowsMobile) {
			if (m.getModel().length() > longestTitle)
				longestTitle = m.getModel().length();

			if (m.getBrand().length() > longestPropietario)
				longestPropietario = m.getBrand().length();
		}
		for (CompactDisc c : rowsCD) {
			if (c.getTitle().length() > longestTitle)
				longestTitle = c.getTitle().length();

			if (c.getArtist().length() > longestPropietario)
				longestPropietario = c.getArtist().length();

			if (c.getGenre().length() > longestInfo)
				longestInfo = c.getGenre().length();
		}

		for (Book b : rowsBook) {
			if (b.getTitle().length() > longestTitle)
				longestTitle = b.getTitle().length();

			if (b.getAuthor().length() > longestPropietario)
				longestPropietario = b.getAuthor().length();
			if (b.getLanguage().length() > longestInfo)
				longestInfo = b.getLanguage().length();
		}

	}

}
