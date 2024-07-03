package airconditioning;

public class AirConditioner {
	public static enum Mode {
		OFF, LOW, HIGH
	}

	private Mode mode = Mode.OFF;

	public void setMode(Mode mode) {
		this.mode = mode;
		System.out.println("   >>> Aire acondicionado en modo " + mode);
	}

	public Mode getMode() {
		return mode;
	}

	public void up() {
		if (mode == Mode.HIGH) {
			System.out.println("   >>> El aire acondicionado ya está al máximo");
		} else if (mode == Mode.LOW) {
			setMode(Mode.HIGH);
		} else {
			setMode(Mode.LOW);
		}
	}

	public void down() {
		if (mode == Mode.OFF) {
			System.out.println("   >>> El aire acondicionado ya está apagado");
		} else if (mode == Mode.HIGH) {
			setMode(Mode.LOW);
		} else {
			setMode(Mode.OFF);
		}
	}

	@Override
	public String toString() {
		return "Aire acondicionado (" + mode + ")";
	}
}
