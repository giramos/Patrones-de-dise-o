package main;

import java.util.List;

public class Pantalla {
	public void imprimeJuegos(List<Juego> juegos) {
		System.out.println("Ranking\tNombre\t\t\tMedia\tVotos");
		for (Juego juego : juegos)
			System.out.println(juego.getRanking() + "\t" + String.format("%1$-24s", juego.getNombre())
					+ juego.getMedia() + '\t' + juego.getVotos());
	}
}
