package main;

import java.util.*;

import main.estrategia.Ordenador;
import main.estrategia.OrdenadorMedia;
import main.estrategia.OrdenadorNombre;
import main.estrategia.OrdenadorRanking;
import main.estrategia.OrdenadorVotos;

public class Controlador {
	static boolean asc;

	public Controlador(List<Juego> juegos, Pantalla pantalla) {
		this.juegos = new ArrayList<Juego>(juegos);
		this.pantalla = pantalla;
		asc = true;
		pantalla.imprimeJuegos(juegos);
	}

	public void pulsadaColumnaRanking() {
		ordenar(new OrdenadorRanking());
	}

	public void pulsadaColumnaNombre() {
		ordenar(new OrdenadorNombre());
	}

	public void pulsadaColumnaMedia() {
		ordenar(new OrdenadorMedia());
	}

	public void pulsadaColumnaVotos() {
		ordenar(new OrdenadorVotos());
	}

	private void ordenar(Ordenador ordenador) {
		ordenador.ordena(juegos, asc);
		pantalla.imprimeJuegos(juegos);
		asc = !asc;
	}

	private List<Juego> juegos;
	private Pantalla pantalla;
}
