package main;

import model.Book;
import model.CompactDisc;
import model.Mobile;
import view.Table;

public class ModeloTable extends Table {

//  (que ponga "Título", "Propietario" e "Información" en la cabecera)
	// - Los móviles muestran su modelo, marca y la tercera columna en blanco.
	// - Los discos muestran su título, artista y género en cada columna.
	// - Los libros muestran su título, autor e idioma
	private int longestBrand = 0, longestModel = 0;
	private int longestTitle = 0, longestArtista = 0, longestGenero = 0;
	private int longestAutor = 0, longestIdioma = 0;

	@Override
	protected void computeRowWidths() {
		longestBrand = longestModel = 0;
		for (Mobile m : rowsMobile) {

			if (m.getModel().length() > longestModel)
				longestModel = m.getModel().length();

			if (m.getBrand().length() > longestBrand)
				longestBrand = m.getBrand().length();

		}

		longestTitle = longestArtista = longestGenero = 0;
		for (CompactDisc cd : rowsCD) {
			if (cd.getTitle().length() > longestTitle)
				longestTitle = cd.getTitle().length();

			if (cd.getArtist().length() > longestArtista)
				longestArtista = cd.getArtist().length();

			if (cd.getGenre().length() > longestGenero)
				longestGenero = cd.getGenre().length();
		}

		longestAutor = longestIdioma = 0;
		for (Book b : rowsBook) {
			if (b.getTitle().length() > longestTitle)
				longestTitle = b.getTitle().length();

			if (b.getAuthor().length() > longestAutor)
				longestAutor = b.getAuthor().length();

			if (b.getLanguage().length() > longestIdioma)
				longestIdioma = b.getLanguage().length();
		}

	}

	@Override
	protected void draw() {
		for (Mobile mobile : rowsMobile)
			printRow(mobile.getModel(), mobile.getBrand(), " ");

		for (CompactDisc cd : rowsCD)
			printRow(cd.getTitle(), cd.getArtist(), cd.getGenre());

		for (Book b : rowsBook)
			printRow(b.getTitle(), b.getAuthor(), b.getLanguage());
	}

	private void printRow(String model, String brand, String string) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(model, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(brand, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(string, longestTitle));
		System.out.println(" |");

	}

	@Override
	protected void printHeader() {
		printSeparator();
		printRow("Título", "Propietario", "Información");
		printSeparator();

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.println("+");

	}

}
