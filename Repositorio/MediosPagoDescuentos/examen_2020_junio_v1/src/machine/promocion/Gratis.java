package machine.promocion;

public class Gratis implements Descuentos {

	@Override
	public double descontar(double amountToPay) {
		return 0;
	}

	@Override
	public String getName() {
		return "Entrada gratuita";
	}

}
