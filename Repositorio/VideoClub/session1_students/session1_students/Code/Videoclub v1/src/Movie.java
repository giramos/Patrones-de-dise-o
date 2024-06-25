import estrategia.TipoPelicula;

public class Movie {
	
	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;
	
	private TipoPelicula tipo;
	
	public Movie(String title, TipoPelicula p) {
		this.title = title;
		this.tipo = p;
	}
	
	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
	
	public String getTitle() {
		return title;
	}	

	int puntosDeAlquiler(Rental rental, int frequentRenterPoints) {
		return tipo.puntosDeAlquiler(frequentRenterPoints);
	}

	double importeAlquiler(Rental rental) {
		return tipo.importeAlquiler(rental.getDaysRented());
	}

	private String title;
	private int priceCode;
}
