package machine.promocion;

public class Porcentaje implements Descuentos {
	
	double porcentaje;

	public Porcentaje(double por) {
		this.porcentaje = por;
	}

	@Override
	public double descontar(double amountToPay) {
		return ((porcentaje * amountToPay) / 100);
	}

	@Override
	public String getName() {
		return "Porcentaje del " + porcentaje;
	}

}
