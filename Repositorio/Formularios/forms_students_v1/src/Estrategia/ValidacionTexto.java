package Estrategia;

public class ValidacionTexto implements Validacion {

	@Override
	public boolean isValid(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

}
