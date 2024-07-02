package main.estrategia;

import java.util.List;

import main.Juego;

public class OrdenadorRanking implements OrdenadorAscendente, OrdenadorDescendente {

	boolean asc;

	public OrdenadorRanking(boolean ascendente) {
		this.asc = ascendente;
	}

	@Override
	public void ordenaAscendente(List<Juego> juegos) {
		if (asc) {
			for (int i = 0; i < (juegos.size() - 1); i++) {
				for (int j = 0; j < juegos.size() - i - 1; j++) {

					Juego juegoA = juegos.get(j);
					Juego juegoB = juegos.get(j + 1);

					boolean intercambiar = false;
					intercambiar = juegoA.getRanking() > juegoB.getRanking();

					if (intercambiar) {
						Juego temp = juegoA;
						juegos.set(j, juegoB);
						juegos.set(j + 1, temp);
					}

				}
			}
		}
	}

	@Override
	public void ordenaDescendente(List<Juego> juegos) {
		if (!asc) {
			for (int i = 0; i < (juegos.size() - 1); i++) {
				for (int j = 0; j < juegos.size() - i - 1; j++) {

					Juego juegoA = juegos.get(j);
					Juego juegoB = juegos.get(j + 1);

					boolean intercambiar = false;
					intercambiar = juegoA.getRanking() < juegoB.getRanking();

					if (intercambiar) {
						Juego temp = juegoA;
						juegos.set(j, juegoB);
						juegos.set(j + 1, temp);
					}

				}
			}
		}

	}

}
