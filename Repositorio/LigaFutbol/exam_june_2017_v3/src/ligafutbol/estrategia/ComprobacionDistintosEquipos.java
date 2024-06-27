package ligafutbol.estrategia;

import ligafutbol.Equipo;

public class ComprobacionDistintosEquipos implements Comprobacion {

	@Override
	public boolean comprobar(Equipo equipo, Equipo candidato) {
		return equipo != candidato;
	}

}
