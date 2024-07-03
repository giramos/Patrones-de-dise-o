package machine.estrategia;

import machine.hardware.CardReader;
import machine.hardware.Display;
import ruralvia.BankGateway;

public class Tarjeta implements MediosPago {
	
	private Display display = new Display();
	private CardReader cardReader = new CardReader();
	private BankGateway bankGateway = new BankGateway();

	@Override
	public boolean pago(double amountToPay) {
		String cardNumber = cardReader.readCardNumber();
		boolean isValid = bankGateway.pay(cardNumber, amountToPay);
		if (!isValid) {
			display.show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		display.show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Pago con tarjeta";
	}

}
