package estrategia;

public class Niños implements TipoPelicula {

	double thisAmount;
	@Override
	public int puntosDeAlquiler(int frequentRenterPoints) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double importeAlquiler(int days) {
		thisAmount += 1.5;
		if (days > 3)
			thisAmount += (days - 3) * 1.5;
		return thisAmount;
	}

}
