package main;

import java.util.*;

import model.*;
import model.adapter.AdapterBook;
import model.adapter.AdapterCompactDisc;
import model.adapter.AdapterMobile;
import model.adapter.AdapterMobile2;
import server.*;
import view.Table;

public class AppVersion4 
{
	public static void main(String[] args) 
	{
		AppVersion4 store = new AppVersion4();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();
		List<Mobile> mobiles = server.downloadMobiles();

		// Parte 1
		// -------
		// Mostrar sólo los móviles en una tabla (que ponga "Marca" y "Modelo" en la cabecera)
		
		Table table = new Table();
		
		for (Mobile m: mobiles) {
			table.insertRow(new AdapterMobile(m));
		}
		table.drawTable("Marca", "Modelo");
		
		/*
			+---------+-----------+
			| Marca   | Modelo    |
			+---------+-----------+
			| Samsung | Galaxy S8 |
			| Apple   | iPhone 8  |
			+---------+-----------+
		*/

		// Parte 2
		// -------
		// Mostrar en una misma tabla los discos, libros y móviles (que ponga "Nombre"
		// y "Propietario" en la cabecera). 
		//
		// Nótese que en esta ocasión, en los móviles, el modelo debe quedar en la
		// columna 1 (nombre) y la marca en la columna 2 (propietario).
		
		 table = new Table();
		for (CompactDisc disco : discs) {
			table.insertRow(new AdapterCompactDisc(disco));
		}
		for (Book b : books) {
			table.insertRow(new AdapterBook(b));
		}
		for (Mobile m: mobiles) {
			table.insertRow(new AdapterMobile2(m));
		}
		table.drawTable("Nombre", "Propietario");
		
		
		/*
			+--------------------+----------------+
			| Nombre             | Propietario    |
			+--------------------+----------------+
			| Despacito          | Luis Fonsi     |
			| Dragon's Kiss      | Marty Friedman |
			| El Código Da Vinci | Dan Brown      |
			| Design Patterns    | Erich Gamma    |
			| Galaxy S8          | Samsung        |
			| iPhone 8           | Apple          |
			+--------------------+----------------+
		*/

		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
		server.uploadMobiles(mobiles);
	}
}
