package estrategia;

public class Regular implements TipoPelicula {
	double thisAmount;

	@Override
	public int puntosDeAlquiler(int frequentRenterPoints) {
		return 1;
	}

	@Override
	public double importeAlquiler(int days) {
		thisAmount += 2;
		if (days > 2)
			thisAmount += (days - 2) * 1.5;
		return thisAmount;
	}

}
