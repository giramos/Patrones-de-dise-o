package ligafutbol;

public class ValidacionEdad implements Validacion {

	@Override
	public boolean valid(Equipo equipo1, Equipo equipo2) {
		return equipo1.getEdad() == equipo2.getEdad();
	}

}
