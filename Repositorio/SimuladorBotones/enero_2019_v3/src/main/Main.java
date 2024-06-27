package main;

import dash.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import simulator.*;

import java.io.*;

import config.*;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Action> acciones = new ArrayList<>();
		acciones.add(fabricacion("null"));
		acciones.add(fabricacion("cafe"));
		acciones.add(fabricacion("gillette"));
		acciones.add(fabricacion("time"));
		
		Dash dash = new Dash(new Action[] { new ActionCoffee(), new ActionNull(), new ActionTime() });
		
		Configurator configurator = new Configurator();
		
		configurator.añadir(acciones);
		menu(dash,configurator);
	}

	public static void menu(Dash dash, Configurator configurator) throws IOException {
		
		Simulator simulator = new Simulator();
		

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("\n===========================");
			System.out.println("MENU PRINCIPAL. Elija opción:");
			System.out.println("    1. Simular Dash");
			System.out.println("    2. Reprogramar botón del Dash");
			System.out.println("    S. Salir");
			System.out.print("> ");

			String line = in.readLine();
			if (line.equals("1"))
				simulator.simulate(dash);
			else if (line.equals("2"))
				configurator.configure(dash);
			else if (line.toUpperCase().equals("S"))
				return;
			else
				System.out.println("Opción desconocida");

		} while (true);
	}

	public static Action fabricacion(String accion) {
		switch (accion.toLowerCase()) {
		case "cafe":
			return new ActionCoffee();
		case "gillette":
			return new ActionGillette();
		case "time":
			return new ActionTime();
		case "null":
			return new ActionNull();
		case "no":
			return new ActionNoReconocida();
		default:
			throw new IllegalArgumentException("Accion desconocida " + accion);

		}

	}

}
