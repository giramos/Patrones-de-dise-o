package Estrategia;

public class ValidacionCantidadMayor implements Validacion {

	int limite;

	public ValidacionCantidadMayor(int i) {
		this.limite = i;
	}

	@Override
	public boolean isValid(String texto) {
		if(Integer.parseInt(texto) >= limite)
			return true;
		return false;
	}

}
