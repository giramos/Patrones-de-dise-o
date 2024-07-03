package machine.estrategia;

import machine.hardware.Display;
import machine.hardware.Keyboard;
import paypal.PayPalAPI;

public class PayPal implements MediosPago {

	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private PayPalAPI payPal = new PayPalAPI();

	@Override
	public boolean pago(double amountToPay) {
		display.show("Iniciando sesión en PayPal...");
		
		display.show("\nIntroduce nombre de usuario:");
		String username = keyboard.readString();
		display.show("\nIntroduzca contraseña:");
		String password = keyboard.readString();

		String token = payPal.logIn(username, password);
		return payPal.checkout(token, amountToPay);

	}

	@Override
	public String getName() {
		return "Pago a través de PayPal";
	}

}
