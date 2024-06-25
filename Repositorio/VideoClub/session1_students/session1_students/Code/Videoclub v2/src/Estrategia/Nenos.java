package Estrategia;

public class Nenos implements TipoMovie {

	double thisAmount;
	@Override
	public double getPrecioAlquiler(int days) {
		thisAmount += 1.5;
		if (days > 3)
			thisAmount += (days - 3) * 1.5;
		return thisAmount;
	}

	@Override
	public int getPuntosAlquiler(int days) {
		return 1;
	}

}
