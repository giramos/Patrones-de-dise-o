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

	double importeAlquiler() {
		double thisAmount = 0;
		
		// Calcula el importe de cada alquiler
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (getDaysRented() > 2) 
				thisAmount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (getDaysRented() > 3)
				thisAmount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	int puntosDeAlquilerFrecuente(int frequentRenterPoints) {
		// Añade los puntos de alquiler frecuente
		frequentRenterPoints++;
		// Un punto extra en el caso de las novedades alquiladas por un período de dos o más días
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) 
			frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private Movie movie;
	private int daysRented;
}
