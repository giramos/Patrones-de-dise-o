package machine.estrategia;

import machine.hardware.BillAcceptor;
import machine.hardware.Display;

public class Efectivo implements MediosPago {
	
	private Display display = new Display();
	private BillAcceptor billAcceptor = new BillAcceptor();

	@Override
	public boolean pago(double amountToPay) {
		int insertedAmount = 0;
		boolean cancel = false;
		billAcceptor.reset();
		do {
			display.show(String.format("Quedan por pagar %.2f €%n", amountToPay - insertedAmount));
			double inserted = billAcceptor.insertBill();
			insertedAmount = billAcceptor.getTotalAmount();
			if (inserted == 0)
				cancel = true;
		} while (insertedAmount < amountToPay && !cancel);

		if (cancel) {
			display.show("Operación cancelada por el usuario\n");
			// si antes de cancelar había introducido dinero, se le devuelve
			if (insertedAmount > 0)
				billAcceptor.returnChange(insertedAmount);
			return false;
		}
		display.show("Pago completado\n");
		// se devuelve el cambio
		if (insertedAmount > amountToPay) {
			billAcceptor.returnChange(insertedAmount - amountToPay);
		}
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Pago en efectivo";
	}

}
