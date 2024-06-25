package ligafutbol;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		List<Validacion> estrategias = new ArrayList<>();
		List<Equipo> equipos = creaEquiposDePrueba();
		GeneradorEmparejamientos generador = new GeneradorEmparejamientos(estrategias);
		Map<Equipo, List<Equipo>> emparejamientos = generador.empareja(equipos);
		
		estrategias.add(new ValidacionEdad());
		estrategias.add(new ValidacionNoContieneCandidato(emparejamientos));
		estrategias.add(new ValidacionNoMismoEquipo());
		estrategias.add(new ValidacionSexo());
		
		imprime(emparejamientos);
	}

	public static List<Equipo> creaEquiposDePrueba() {
		List<Equipo> equipos = new ArrayList<Equipo>();

		equipos.add(new Equipo("Callealteros", "Cantabria", true, 10));
		equipos.add(new Equipo("Racing de Tenderina", "Asturias", false, 11));
		equipos.add(new Equipo("Colegio Ramón Pelayo", "Cantabria", false, 10));
		equipos.add(new Equipo("Real Uría", "Asturias", true, 10));
		equipos.add(new Equipo("Los Maragatos", "León", true, 10));
		equipos.add(new Equipo("Sporting de León", "León", false, 11));

		return equipos;
	}

	public static void imprime(Map<Equipo, List<Equipo>> emparejamientos) {
		for (Equipo equipo : emparejamientos.keySet()) {
			System.out.println("Contrincantes de " + equipo + ": ");
			for (Equipo contrincante : emparejamientos.get(equipo)) {
				System.out.println("\t> " + contrincante);
			}
			System.out.println();
		}
	}
}
