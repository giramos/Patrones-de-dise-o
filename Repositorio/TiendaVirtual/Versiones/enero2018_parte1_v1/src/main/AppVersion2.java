package main;

import java.util.*;

import model.*;
import model.adapter.AdapterBook;
import server.*;
import view.Table;

public class AppVersion2 
{
	public static void main(String[] args) 
	{
		AppVersion2 store = new AppVersion2();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<Book> books = server.downloadBooks();

		// Mostrar sólo los libros en una tabla (que ponga "Título" y "Autor" en la cabecera)
		// 1. Mostrando los datos del servidor
		Table table = new Table();
		for (Book b : books) {
			table.insertRow(new AdapterBook(b));
		}
		table.drawTable("Titulo", "Autor");

		/*
			+--------------------+-------------+
			| Titulo             | Autor       |
			+--------------------+-------------+
			| El Código Da Vinci | Dan Brown   |
			| Design Patterns    | Erich Gamma |
			+--------------------+-------------+
		 */

		server.uploadBooks(books);
	}
}
