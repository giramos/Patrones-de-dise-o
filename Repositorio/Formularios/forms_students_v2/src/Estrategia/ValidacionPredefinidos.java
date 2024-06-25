package Estrategia;
public class ValidacionPredefinidos implements Validacion {

	private String[] predefinidos;

	public ValidacionPredefinidos(String... ciudades) {
		this.predefinidos = ciudades;
	}

	@Override
	public boolean isValid(String texto) {
		for (String each : predefinidos) {
			if (texto.toLowerCase().equals(each.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
