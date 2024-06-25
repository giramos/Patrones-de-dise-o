package Estrategia;
public class ValidacionNumero implements Validacion {

	@Override
	public boolean isValid(String texto) {
		for (char ch : texto.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

}
