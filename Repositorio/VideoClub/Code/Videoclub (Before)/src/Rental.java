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

	private Movie movie;
	private int daysRented;
}
