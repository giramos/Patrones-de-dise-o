package machine.promocion;

public class Nada implements Descuentos {

	@Override
	public double descontar(double amountToPay) {
		return amountToPay;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "No escoger ninguna promoción";
	}

}
