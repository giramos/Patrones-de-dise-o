package ligafutbol;

public class ConsdicionesEdad implements Condiciones {

	@Override
	public boolean condicion(Equipo equipo, Equipo candidato) {
		return equipo.getEdad() == candidato.getEdad();
	}

}
