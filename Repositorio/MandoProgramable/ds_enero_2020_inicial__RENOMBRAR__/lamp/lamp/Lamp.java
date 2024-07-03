package lamp;

public class Lamp {
	private boolean isOn;

	public boolean isOn() {
		return isOn;
	}

	public void turnOn() {
		isOn = true;
		System.out.println("   >>> Se encendió la luz");
	}

	public void turnOff() {
		isOn = false;
		System.out.println("   >>> Se apagó la luz");
	}

	@Override
	public String toString() {
		return isOn() ? "Luz encendida" : "Luz apagada";
	}
}
