package machine.promocion;

public class Fijo implements Descuentos {
	
	double cantidadFija;
	
	public Fijo(double cantidad) {
		this.cantidadFija = cantidad;
	}

	@Override
	public double descontar(double amountToPay) {
		if(amountToPay < cantidadFija)
			return 0.0;
		return amountToPay - cantidadFija;
	}

	@Override
	public String getName() {
		return "Cantidad fija: " + cantidadFija ;
	}

}
