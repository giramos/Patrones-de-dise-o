package ligafutbol;

public class ValidacionSexo implements Validacion {

	@Override
	public boolean valid(Equipo equipo1, Equipo equipo2) {
		return equipo1.isMasculino() == equipo2.isMasculino();
	}

}
