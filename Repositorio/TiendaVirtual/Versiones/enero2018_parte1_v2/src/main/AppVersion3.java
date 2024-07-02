package main;

import java.util.*;

import model.*;
import server.*;
import view.Table;

public class AppVersion3 
{
	public static void main(String[] args) 
	{
		AppVersion3 store = new AppVersion3();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();

		// Mostrar en una misma tabla los discos y los libros
		// (que ponga "Título" y "Autor" en la cabecera)
		
		Table table = new Table();
		for (CompactDisc cd : discs) {
			table.insertRow(new CDAdapter(cd));
		}
		for (Book book : books) {
			table.insertRow(new BookAdapter(book));
		}
		table.drawTable("Titulo", "Autor");

		/*
			+--------------------+----------------+
			| Título             | Autor          |
			+--------------------+----------------+
			| Despacito          | Luis Fonsi     |
			| Dragon's Kiss      | Marty Friedman |
			| El Código Da Vinci | Dan Brown      |
			| Design Patterns    | Erich Gamma    |
			+--------------------+----------------+
		 */

		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
	}
}
