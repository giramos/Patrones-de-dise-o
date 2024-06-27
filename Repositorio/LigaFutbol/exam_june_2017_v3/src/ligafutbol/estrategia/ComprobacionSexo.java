package ligafutbol.estrategia;

import ligafutbol.Equipo;

public class ComprobacionSexo implements Comprobacion {

	@Override
	public boolean comprobar(Equipo equipo, Equipo candidato) {
		// TODO Auto-generated method stub
		return equipo.isMasculino() == candidato.isMasculino();
	}

}
