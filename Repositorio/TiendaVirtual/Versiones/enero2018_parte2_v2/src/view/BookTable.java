package view;

import model.Book;

public class BookTable extends Table {

	private int longestTitle = 0;
	private int longestAutor = 0;
	private int longestEditorial = 0;
	private int longestIdioma = 0;

	@Override
	protected void printHeader() {

		printSeparator();
		printRow("Título", "Autor", "Editorial", "Idioma");
		printSeparator();

	}

	void printRow(String title, String autor, String editorial, String idioma) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(autor, longestAutor));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(editorial, longestEditorial));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(idioma, longestIdioma));
		System.out.println(" |");

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestAutor + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestEditorial + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestIdioma + 2));
		System.out.println("+");
	}

	@Override
	protected void draw() {

		for (Book b : rowsBook)
			printRow(b.getTitle(), b.getAuthor(), b.getEditorial(), b.getLanguage());

	}

	@Override
	protected void computeRowWidths() {
		longestTitle = longestAutor = longestEditorial = longestIdioma = 0;
		for (Book b : rowsBook) {
			if (b.getTitle().length() > longestTitle)
				longestTitle = b.getTitle().length();

			if (b.getAuthor().length() > longestAutor)
				longestAutor = b.getAuthor().length();

			if (b.getEditorial().length() > longestEditorial)
				longestEditorial = b.getEditorial().length();

			if (b.getLanguage().length() > longestIdioma)
				longestIdioma = b.getLanguage().length();
		}

	}

}
