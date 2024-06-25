// Representa el alquiler de una película por parte de un cliente.
public class Rental  {
	
	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	int getPuntosAlquiler() {
		return movie.getPuntosAlquiler(daysRented);
	}

	double getPrecioAlquiler() {
		return movie.getPrecioAlquiler(daysRented);
	}

	private Movie movie;
	private int daysRented;
}
