package main.estrategia;

import java.util.List;

import main.Juego;

public class OrdenadorVotos implements Ordenador {

	@Override
	public void ordena(List<Juego> juegos, boolean ascendente) {
		for (int i = 0; i < (juegos.size() - 1); i++) {
			for (int j = 0; j < juegos.size() - i - 1; j++) {

				Juego juegoA = juegos.get(j);
				Juego juegoB = juegos.get(j + 1);

				boolean intercambiar = false;
				if (ascendente) {
					intercambiar = juegoA.getVotos() > juegoB.getVotos();
				} else {
					intercambiar = juegoA.getVotos() < juegoB.getVotos();
				}
				if (intercambiar) {
					Juego temp = juegoA;
					juegos.set(j, juegoB);
					juegos.set(j + 1, temp);
				}

			}
		}

	}

}
