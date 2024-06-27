package ligafutbol;

public class CondicionesDistintoEquipo implements Condiciones {

	@Override
	public boolean condicion(Equipo equipo, Equipo candidato) {
		return equipo != candidato;
	}

}
