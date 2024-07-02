package view;

import java.util.*;

import model.*;

public class Table 
{
	//-- Métodos públicos
	//-------------------------------------------------------------

	public void insertRow(Articulo book) 
	{
		rows.add(book);
	}

	public void drawTable(String cadena1, String cadena2) 
	{
		computeRowWidths();

		printHeader(cadena1, cadena2);
		for (Articulo ar : rows)
			printRow(ar.getCadena1(), ar.getCadena2());
		printSeparator();
		System.out.println();
	}

	//-- Métodos privados
	//-------------------------------------------------------------

	private void computeRowWidths() 
	{
		longestCadena1 = longestCadena2 = 0;
		for (Articulo art : rows) {
			if (art.getCadena1().length() > longestCadena1)
				longestCadena1 = art.getCadena1().length();

			if (art.getCadena2().length() > longestCadena2)
				longestCadena2 = art.getCadena2().length();
		}
	}

	private void printHeader(String cadena1, String cadena2) 
	{	
		printSeparator();
		printRow(cadena1, cadena2);
		printSeparator();
	}

	private void printRow(String title, String artist) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestCadena1));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestCadena2));
		System.out.println(" |");
	}

	private void printSeparator() 
	{
		System.out.print("+");
		System.out.print(createDashedLine(longestCadena1 + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestCadena2 + 2));
		System.out.println("+");
	}

	/** 
	 * Si el ancho del texto recibido como parámetro es menor que el deseado
	 * añade espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo:
	 * 		fillWithBlanks("abc", 5)  ->   "abc  " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) 
	{
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo:
	 * 		createDashedLine(5)  ->   "-----"
	 */
	private String createDashedLine(int ancho) 
	{
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}

	private List<Articulo> rows = new ArrayList<Articulo>();
	private int longestCadena1 = 0, longestCadena2 = 0;
}
