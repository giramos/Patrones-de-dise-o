package view;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.CompactDisc;

public class CompactDiscTable extends Table {

	@Override
	protected void computeRowWidths() {
		longestTitle = longestArtista = longestGenero = 0;
		for (CompactDisc cd : rowsCD) {
			if (cd.getTitle().length() > longestTitle)
				longestTitle = cd.getTitle().length();

			if (cd.getArtist().length() > longestArtista)
				longestArtista = cd.getArtist().length();
			
			if (cd.getGenre().length() > longestGenero)
				longestGenero = cd.getGenre().length();
		}

	}

	@Override
	protected void printHeader() {
		printSeparator();
		printRow("Título", "Artista", "Género");
		printSeparator();

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

	private void printRow(String titulo, String artista, String genero) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(titulo, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artista, longestArtista));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(genero, longestGenero));
		System.out.println(" |");

	}

	private int longestTitle = 0, longestArtista = 0 , longestGenero= 0;

	@Override
	protected void draw() {
		for (CompactDisc cd : rowsCD)
			printRow(cd.getTitle(), cd.getArtist(), cd.getGenre());

	}
}
