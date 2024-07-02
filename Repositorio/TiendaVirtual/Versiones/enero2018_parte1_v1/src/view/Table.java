package view;

import java.util.*;

import model.*;

public class Table 
{
	//-- Métodos públicos
	//-------------------------------------------------------------

	public void insertRow(Articulo cd) 
	{
		rows.add(cd);
	}

	public void drawTable(String uno, String dos) 
	{
		computeRowWidths();

		printHeader(uno, dos);
		for (Articulo art : rows)
			printRow(art.etiquetaUno(), art.etiquetaDos());
		printSeparator();
		System.out.println();
	}

	//-- Métodos privados
	//-------------------------------------------------------------

	private void computeRowWidths() 
	{
		longestTitle = longestArtist = 0;
		for (Articulo art : rows) {
			if (art.etiquetaUno().length() > longestTitle)
				longestTitle = art.etiquetaUno().length();

			if (art.etiquetaDos().length() > longestArtist)
				longestArtist = art.etiquetaDos().length();
		}
	}

	private void printHeader(String uno, String dos) 
	{	
		printSeparator();
		printRow(uno, dos);
		printSeparator();
	}

	private void printRow(String title, String artist) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestArtist));
		System.out.println(" |");
	}

	private void printSeparator() 
	{
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtist + 2));
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

//	private List<CompactDisc> rows = new ArrayList<CompactDisc>();
	private List<Articulo> rows = new ArrayList<Articulo>();

	private int longestTitle = 0, longestArtist = 0;
}
