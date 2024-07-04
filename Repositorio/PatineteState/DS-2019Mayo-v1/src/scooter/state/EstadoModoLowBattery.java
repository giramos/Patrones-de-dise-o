package scooter.state;

import scooter.Scooter;
import scooter.Scooter.Mode;

public class EstadoModoLowBattery extends AbstractEstadoModo {

	public EstadoModoLowBattery(Scooter s) {
		super(s);
	}

	@Override
	public void showDisplay() {
		String drivingMode = "";
		drivingMode = "LOW";
		s.display.show(s.getSpeed(), s.distance, s.elapsedTime, drivingMode, s.light.isOn(), s.getBatteryLevel());
	}

	@Override
	public void checkBatteryLevel() {
		if (s.battery.isEmpty()) {
			s.display.alert("Se agotó la batería: el patinete va a apagarse...");
			showDisplay();
			turnOff();
			s.setMode(Mode.OFF);
		}
	}

}
