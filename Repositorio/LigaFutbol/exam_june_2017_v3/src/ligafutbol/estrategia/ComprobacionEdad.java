package ligafutbol.estrategia;

import ligafutbol.Equipo;

public class ComprobacionEdad implements Comprobacion {

	@Override
	public boolean comprobar(Equipo equipo, Equipo candidato) {
		// TODO Auto-generated method stub
		return equipo.getEdad() == candidato.getEdad();
	}

}
