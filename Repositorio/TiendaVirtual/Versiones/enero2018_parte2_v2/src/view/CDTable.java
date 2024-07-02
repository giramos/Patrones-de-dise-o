package view;

import model.CompactDisc;

public class CDTable extends Table {

	private int longestTitle = 0;
	private int longestArtista = 0;
	private int longestGenero = 0;

	@Override
	protected void printHeader() {

		printSeparator();
		printRow("Título", "Artista", "Género");
		printSeparator();

	}

	void printRow(String title, String autor, String editorial) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(autor, longestArtista));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(editorial, longestGenero));
		System.out.println(" |");

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtista + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestGenero + 2));
		System.out.println("+");
	}

	@Override
	protected void draw() {

		for (CompactDisc c : rowsCD)
			printRow(c.getTitle(), c.getArtist(), c.getGenre());

	}

	@Override
	protected void computeRowWidths() {
		longestTitle = longestArtista = longestGenero = 0;
		for (CompactDisc c : rowsCD) {
			if (c.getTitle().length() > longestTitle)
				longestTitle = c.getTitle().length();

			if (c.getArtist().length() > longestArtista)
				longestArtista = c.getArtist().length();

			if (c.getGenre().length() > longestGenero)
				longestGenero = c.getGenre().length();
		}

	}

}
