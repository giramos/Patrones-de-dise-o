package view;

import model.Mobile;

public class MobileTable extends Table {

	private int longestModelo = 0;
	private int longestMarca = 0;

	@Override
	protected void printHeader() {

		printSeparator();
		printRow("Modelo", "Marca");
		printSeparator();

	}

	void printRow(String title, String autor) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestModelo));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(autor, longestMarca));
		System.out.println(" |");

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestModelo + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestMarca + 2));
		System.out.println("+");
	}

	@Override
	protected void draw() {

		for (Mobile m : rowsMobile)
			printRow(m.getModel(), m.getBrand());

	}

	@Override
	protected void computeRowWidths() {
		longestModelo = longestMarca = 0;
		for (Mobile m : rowsMobile) {

			if (m.getModel().length() > longestMarca)
				longestMarca = m.getModel().length();
			if (m.getBrand().length() > longestModelo)
				longestModelo = m.getBrand().length();

		}

	}

}
