package Estrategia;

public class Regular implements TipoMovie {

	double thisAmount;
	@Override
	public double getPrecioAlquiler(int days) {
		thisAmount += 2;
		if (days > 2) 
			thisAmount += (days - 2) * 1.5;
		return thisAmount;
	}

	@Override
	public int getPuntosAlquiler(int days) {
		return 1;
	}

}
