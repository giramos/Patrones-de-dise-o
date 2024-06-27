package ligafutbol;

public class CondicionesSexo implements Condiciones {

	@Override
	public boolean condicion(Equipo equipo, Equipo candidato) {
		return equipo.isMasculino() == candidato.isMasculino();
	}

}
