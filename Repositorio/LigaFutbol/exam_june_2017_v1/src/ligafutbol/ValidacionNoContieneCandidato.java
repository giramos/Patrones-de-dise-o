package ligafutbol;

import java.util.List;
import java.util.Map;

public class ValidacionNoContieneCandidato implements Validacion {
	Map<Equipo, List<Equipo>> emparejamientos;

	public ValidacionNoContieneCandidato(Map<Equipo, List<Equipo>> emparejamientos) {
		this.emparejamientos = emparejamientos;
	}

	@Override
	public boolean valid(Equipo equipo1, Equipo equipo2) {
		return !emparejamientos.get(equipo1).contains(equipo2);
	}

}
