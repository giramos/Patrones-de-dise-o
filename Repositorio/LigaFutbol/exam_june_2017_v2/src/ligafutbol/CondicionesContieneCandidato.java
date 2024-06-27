package ligafutbol;

import java.util.List;
import java.util.Map;

public class CondicionesContieneCandidato implements Condiciones {
	
	Map<Equipo, List<Equipo>> emparejamientos;

	public CondicionesContieneCandidato(Map<Equipo, List<Equipo>> emparejamientos) {
		this.emparejamientos = emparejamientos;
	}
	@Override
	public boolean condicion(Equipo equipo, Equipo candidato) {
		return !emparejamientos.get(equipo).contains(candidato);
	}

}
