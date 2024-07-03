package main;

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Controlador controlador = new Controlador(creaModeloDePrueba(), new Pantalla());
		InterfazDeUsuario interfaz = new InterfazDeUsuario(controlador);
		interfaz.run();
	}

	private static List<Juego> creaModeloDePrueba() {
		List<Juego> juegos = new ArrayList<Juego>();
		juegos.add(new Juego(1, "7 Wonders", 7.88, 31638));
		juegos.add(new Juego(3, "Stone Age", 7.65, 21160));
		juegos.add(new Juego(4, "Pandemic", 7.66, 38109));
		juegos.add(new Juego(8, "Aventureros al Tren", 7.51, 33388));
		juegos.add(new Juego(23, "Los Colonos de Catán", 7.38, 49354));

		return juegos;
	}
}
