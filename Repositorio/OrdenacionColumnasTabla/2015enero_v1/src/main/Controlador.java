package main;

import java.util.*;

import main.estrategia.OrdenadorAscendente;
import main.estrategia.OrdenadorDescendente;
import main.estrategia.OrdenadorMedia;
import main.estrategia.OrdenadorNombre;
import main.estrategia.OrdenadorRanking;
import main.estrategia.OrdenadorVotos;

public class Controlador {

	private OrdenadorAscendente estrategia;
	private OrdenadorDescendente descendente;
	boolean asc;
	
	public Controlador(List<Juego> juegos, Pantalla pantalla) {
		this.juegos = new ArrayList<Juego>(juegos);
		this.pantalla = pantalla;

		pantalla.imprimeJuegos(juegos);
		this.asc = true;
	}

	public void pulsadaColumnaRanking() {
		new OrdenadorRanking(asc);
		ordena();
		asc = !asc;
	}

	public void pulsadaColumnaNombre() {
		new OrdenadorNombre(asc);
		ordena();
		asc = !asc;
	}

	public void pulsadaColumnaMedia() {
		new OrdenadorMedia(asc);
		ordena();
		asc = !asc;
	}

	public void pulsadaColumnaVotos() {
		new OrdenadorVotos(asc);
		ordena();
		asc = !asc;
	}

	public void ordena() {
		if(asc)
			estrategia.ordenaAscendente(juegos);
		descendente.ordenaDescendente(juegos);
		pantalla.imprimeJuegos(juegos);
	}



	private List<Juego> juegos;
	private Pantalla pantalla;
}
