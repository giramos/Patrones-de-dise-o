package ligafutbol.estrategia;

import java.util.List;
import java.util.Map;

import ligafutbol.Equipo;

public class ComprobacionContieneCandidato implements Comprobacion {

	Map<Equipo, List<Equipo>> emparejamientos;
	public ComprobacionContieneCandidato(Map<Equipo, List<Equipo>> emparejamientos) {
		this.emparejamientos = emparejamientos;
	}

	@Override
	public boolean comprobar(Equipo equipo, Equipo candidato) {
		return !emparejamientos.get(equipo).contains(candidato);
	}

}
