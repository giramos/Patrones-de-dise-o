package view;

import model.Mobile;

public class MobileTable extends Table {

	@Override
	protected void computeRowWidths() {
		longestBrand = longestModel = 0;
		for (Mobile m : rowsMobile) {

			if (m.getModel().length() > longestModel)
				longestModel = m.getModel().length();

			if (m.getBrand().length() > longestBrand)
				longestBrand = m.getBrand().length();

		}

	}

	@Override
	protected void printHeader() {
		printSeparator();
		printRow("Modelo", "Marca");
		printSeparator();

	}

	@Override
	protected void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestModel + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestBrand + 2));
		System.out.println("+");

	}

	private void printRow(String modelo, String marca) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(modelo, longestModel));
		System.out.print(" | ");

		System.out.print(fillWithBlanks(marca, longestBrand));
		System.out.println(" |");

	}

	private int longestBrand = 0, longestModel = 0;

	@Override
	protected void draw() {
		for (Mobile mobile : rowsMobile)
			printRow( mobile.getModel(), mobile.getBrand());

	}
}
