package estrategia;

public class Nueva implements TipoPelicula {
	double thisAmount;

	@Override
	public int puntosDeAlquiler(int frequentRenterPoints) {
		return 1;
	}

	@Override
	public double importeAlquiler(int days) {
		return thisAmount += days * 3;
	}

}
