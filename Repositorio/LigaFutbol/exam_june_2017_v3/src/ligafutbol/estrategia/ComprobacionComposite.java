package ligafutbol.estrategia;

import java.util.*;

import ligafutbol.Equipo;

public class ComprobacionComposite implements Comprobacion {

	public List<Comprobacion> lista;
	public ComprobacionComposite() {
		lista = new ArrayList<>();
	}
	@Override
	public boolean comprobar(Equipo equipo, Equipo candidato) {
		for(Comprobacion c: lista) {
			if(!c.comprobar(equipo, candidato)) {
				return false;
			}
		}
		return true;
	}

	public void añadir(Comprobacion comprobacion) {
		lista.add(comprobacion);
	}
}
