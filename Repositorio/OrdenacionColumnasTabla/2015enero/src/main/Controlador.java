package main;

import java.util.*;

public class Controlador {

	public Controlador(List<Juego> juegos, Pantalla pantalla) {
		this.juegos = new ArrayList<Juego>(juegos);
		this.pantalla = pantalla;

		pantalla.imprimeJuegos(juegos);
	}

	public void pulsadaColumnaRanking() {
		ordena(juegos, 1);
		pantalla.imprimeJuegos(juegos);
	}

	public void pulsadaColumnaNombre() {
		ordena(juegos, 2);
		pantalla.imprimeJuegos(juegos);
	}

	public void pulsadaColumnaMedia() {
		ordena(juegos, 3);
		pantalla.imprimeJuegos(juegos);
	}

	public void pulsadaColumnaVotos() {
		ordena(juegos, 4);
		pantalla.imprimeJuegos(juegos);
	}

	public void ordena(List<Juego> juegos, int campo) {
		for (int i = 0; i < (juegos.size() - 1); i++) {
			for (int j = 0; j < juegos.size() - i - 1; j++) {

				Juego juegoA = juegos.get(j);
				Juego juegoB = juegos.get(j + 1);

				boolean intercambiar = false;
				if (campo == 1)
					intercambiar = juegoA.getRanking() > juegoB.getRanking();
				else if (campo == 2)
					intercambiar = juegoA.getNombre().compareTo(juegoB.getNombre()) > 0;
				else if (campo == 3)
					intercambiar = juegoA.getMedia() > juegoB.getMedia();
				else if (campo == 4)
					intercambiar = juegoA.getVotos() > juegoB.getVotos();

				if (intercambiar) {
					Juego temp = juegoA;
					juegos.set(j, juegoB);
					juegos.set(j + 1, temp);
				}

			}
		}
	}

	private List<Juego> juegos;
	private Pantalla pantalla;
}
