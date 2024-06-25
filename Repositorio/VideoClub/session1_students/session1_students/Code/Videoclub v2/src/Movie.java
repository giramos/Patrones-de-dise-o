import Estrategia.TipoMovie;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int NEW_RELEASE = 1;
	public static final int REGULAR = 0;

	private TipoMovie tipo;
	private String title;
	private int priceCode;

	public Movie(String title, TipoMovie priceCode) {
		this.title = title;
		this.tipo = priceCode;
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

	double getPrecioAlquiler(int days) {
		return this.tipo.getPrecioAlquiler(days);
	}

	int getPuntosAlquiler(int days) {
		return this.tipo.getPuntosAlquiler(days);
	}


}
