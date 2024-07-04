package scooter.state;

import scooter.Scooter;

public class EstadoModoCharging extends AbstractEstadoModo {

	public EstadoModoCharging(Scooter s) {
		super(s);
	}

	@Override
	public void showDisplay() {
		s.display.charging(s.getBatteryLevel());

	}

	@Override
	public void turnAccelerator(int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressPowerButton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void longPressPowerButton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plugPowerAdapter() {
		throw new IllegalStateException("¡¿Cómo se va a recibir esta llamada si ya está enchufado?!");

	}

	@Override
	public void unplugPowerAdapter() {
		throw new IllegalStateException("¡¿Cómo se va a desenchufar sin estar enchufado?!");

	}

	@Override
	public void advanceOneMinute() {
		s.battery.charge(0.196078431372549);

	}


}
