package main;

import java.util.*;

import model.*;
import server.*;

public class Inventory {

	public static void main(String[] args) 
	{
		Inventory tienda = new Inventory();
		tienda.openWindow();
	}

	public void openWindow() 
	{
		int stockItems = 0;
		Server server = new Server();

		List<Mobile> mobiles = server.downloadMobiles();
		System.out.println("Hay " + mobiles.size() + " móviles en el almacén.");
		stockItems += mobiles.size();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		System.out.println("Hay " + discs.size() + " discos en el almacén.");
		stockItems += discs.size();

		List<Book> books = server.downloadBooks();
		System.out.println("Hay " + books.size() + " libros en el almacén.");
		stockItems += books.size();

		System.out.println("Hay " + stockItems + " artículos en TOTAL en el almacén.");
	}
}
