package scooter.state;

import scooter.Scooter;
import scooter.Scooter.Mode;

public class EstadoModoOff extends AbstractEstadoModo {

	public EstadoModoOff(Scooter s) {
		super(s);
	}

	@Override
	public void showDisplay() {
		return;

	}

	@Override
	public void turnAccelerator(int amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressPowerButton() {
		if (s.battery.isEmpty()) {
			s.display.alert("Batería insuficiente: cargue el patinete para poder encenderlo");
			return;
		}
		turnOn();
		if (s.battery.isLow()) {
			s.motor.setMaximumSpeed(5);
			s.setMode(Mode.LOW_BATTERY);
		} else {
			s.motor.setMaximumSpeed(25);
			s.setMode(Mode.DRIVE);
		}

	}

	@Override
	public void longPressPowerButton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plugPowerAdapter() {
		turnOff();
		s.setMode(Mode.CHARGING);

	}

	@Override
	public void unplugPowerAdapter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void advanceOneMinute() {
		// TODO Auto-generated method stub

	}

}
