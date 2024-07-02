package main;

import java.util.*;

import main.estrategia.Ordenador;
import main.estrategia.OrdenadorMedia;
import main.estrategia.OrdenadorNombre;
import main.estrategia.OrdenadorRanking;
import main.estrategia.OrdenadorVotos;

public class Controlador {

	boolean ascendente = true;

	public Controlador(List<Juego> juegos, Pantalla pantalla) {
		this.juegos = new ArrayList<Juego>(juegos);
		this.pantalla = pantalla;

		pantalla.imprimeJuegos(juegos);
	}

	public void pulsadaColumnaRanking() {
		ordena(new OrdenadorRanking(ascendente));
		cambiarAscendencia(ascendente);
	}

	public void pulsadaColumnaNombre() {
		ordena(new OrdenadorNombre(ascendente));
		cambiarAscendencia(ascendente);
	}

	public void pulsadaColumnaMedia() {
		ordena(new OrdenadorMedia(ascendente));
		cambiarAscendencia(ascendente);
	}

	public void pulsadaColumnaVotos() {
		ordena(new OrdenadorVotos(ascendente));
		cambiarAscendencia(ascendente);

	}

	public void ordena(Ordenador ordenador) {
		ordenador.ordena(juegos);
		pantalla.imprimeJuegos(juegos);
	}

	private void cambiarAscendencia(boolean ascendente) {
		if (ascendente == true) {
			this.ascendente = false;
		} else {
			this.ascendente = true;
		}

	}

	private List<Juego> juegos;
	private Pantalla pantalla;
}
