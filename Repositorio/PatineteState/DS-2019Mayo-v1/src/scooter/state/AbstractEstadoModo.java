package scooter.state;

import scooter.Scooter;
import scooter.Scooter.Mode;

public abstract class AbstractEstadoModo implements EstadoModo {
	
	Scooter s;
	
	public AbstractEstadoModo(Scooter s) {
		this.s = s;
	}

	@Override
	public void showDisplay() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnAccelerator(int amount) {
		s.motor.accelerate(amount);

	}

	@Override
	public void pressPowerButton() {
		if (s.light.isOn())
			s.light.turnOff();
		else
			s.light.turnOn();

	}

	@Override
	public void longPressPowerButton() {
		if (s.motor.getSpeed() > 0) {
			s.display.alert("No se puede apagar el patinete estando en movimiento");
			return;
		}
		turnOff();	
		s.setMode(Mode.OFF);

	}

	@Override
	public void doublePressPowerButton() {
		// TODO Auto-generated method stub

	}

	@Override
	public void plugPowerAdapter() {
		s.setMode(Mode.CHARGING);

	}

	@Override
	public void unplugPowerAdapter() {
		s.setMode(Mode.OFF);
	}

	@Override
	public void advanceOneMinute() {
		s.motor.updateComsumption(1);
		s.elapsedTime++; 
		// distancia en metros recorrida en un minuto a la velocidad actual:
		double distance = (double) s.motor.getSpeed() * 1000 / 60;
		s.distance += distance;
		// comprueba la carga de batería restante por si hiciera falta cambiar de modo
		checkBatteryLevel();

	}

	@Override
	public void checkBatteryLevel() {
		// TODO Auto-generated method stub

	}

	protected void turnOn() {
		s.elapsedTime = 0;
		s.distance = 0;
		s.motor.turnOn();
	}

	protected void turnOff() {
		s.light.turnOff();
		s.motor.turnOff();
	}
}
