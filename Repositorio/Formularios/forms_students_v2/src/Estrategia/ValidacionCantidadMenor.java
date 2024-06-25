package Estrategia;

public class ValidacionCantidadMenor implements Validacion {

	int limite;

	public ValidacionCantidadMenor(int i) {
		this.limite = i;
	}

	@Override
	public boolean isValid(String texto) {
		if(Integer.parseInt(texto) <= limite)
			return true;
		return false;
	}

}
