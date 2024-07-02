package main.estrategia;

import java.util.List;

import main.Juego;

public class OrdenadorNombre implements Ordenador {
	
	private boolean ascendente;

	public OrdenadorNombre(boolean ascendente) {
		this.ascendente = ascendente;
	}

	@Override
	public void ordena(List<Juego> juegos) {
		for (int i = 0; i < (juegos.size() - 1); i++) {
			for (int j = 0; j < juegos.size() - i - 1; j++) {

				Juego juegoA = juegos.get(j);
				Juego juegoB = juegos.get(j + 1);

				boolean intercambiar = false;
				if(ascendente) {
					intercambiar = juegoA.getNombre().compareTo(juegoB.getNombre()) > 0;
				}else {
					intercambiar = juegoA.getNombre().compareTo(juegoB.getNombre()) < 0;
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
