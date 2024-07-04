package scooter.state;

import scooter.Scooter;
import scooter.Scooter.Mode;

public class EstadoModoDrive extends AbstractEstadoModo {
	
	public EstadoModoDrive(Scooter s) {
		super(s);
	}

	@Override
	public void showDisplay() {
		String drivingMode = "";
		drivingMode = "D";
		s.display.show(s.getSpeed(), s.distance, s.elapsedTime, drivingMode, s.light.isOn(), s.getBatteryLevel());

	}


	@Override
	public void checkBatteryLevel() {
		if (s.battery.isEmpty()) {
			s.display
					.alert("Se agotó la batería: el patinete va a apagarse...");
			// muestra el estado actual del patinete justo antes de apagarse
			showDisplay();
			// se apaga el patinete
			turnOff();
			s.setMode(Mode.OFF);
		} else if (s.battery.isLow()) {
			s.display.alert("Cambiando al modo de batería baja...");
			s.motor.setMaximumSpeed(5);
			s.setMode(Mode.LOW_BATTERY);
		}

	}
	

}
