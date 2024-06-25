import java.util.List;
import java.util.ArrayList;

public class Customer {
	
	public Customer(String name) {
		this.name = name;
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}
	
	public String getName() {
		return name;
	}
	
	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each : rentals) {
			double thisAmount = 0;
			
			// Calcula el importe de cada alquiler
			thisAmount = each.getPrecioAlquiler();
			
			// Añade los puntos de alquiler frecuente
			
			frequentRenterPoints += each.getPuntosAlquiler();
			
			// Muestra el importe de esta película alquilada
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		// Añade las líneas de total
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}

	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
}
