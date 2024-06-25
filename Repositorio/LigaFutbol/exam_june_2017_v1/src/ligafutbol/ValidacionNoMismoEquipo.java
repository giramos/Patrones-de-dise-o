package ligafutbol;

public class ValidacionNoMismoEquipo implements Validacion {

	@Override
	public boolean valid(Equipo equipo1, Equipo equipo2) {
		// TODO Auto-generated method stub
		return equipo1 != equipo2;
	}

}
