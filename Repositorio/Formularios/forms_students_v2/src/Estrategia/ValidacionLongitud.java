package Estrategia;

public class ValidacionLongitud implements Validacion {

	int limite;

	public ValidacionLongitud(int i) {
		this.limite = i;
	}

	@Override
	public boolean isValid(String texto) {
		if (texto.length() < limite) {
			return false;
		}
		return true;
	}

}
