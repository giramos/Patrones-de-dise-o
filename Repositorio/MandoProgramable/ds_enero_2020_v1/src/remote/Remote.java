package remote;

import java.io.PrintStream;

import tv.TV;

public class Remote {
	public enum Button {
		ONE, TWO, THREE, FOUR, FIVE, SIX
	}

	private TV tv = new TV();

	public void buttonPressed(Button button) {
		if (button == Button.ONE) {
			// enciende o apaga el televisor, según corresponda
			if (tv.isOn())
				tv.turnOff();
			else
				tv.turnOn();
		} else if (button == Button.TWO) { // canal 1
			tv.setChannel(1);
		} else if (button == Button.THREE) { // canal 3
			tv.setChannel(3);
		} else if (button == Button.FOUR) { // canal 15
			tv.setChannel(15);
		} else if (button == Button.FIVE) {
			tv.volumeUp(); // subir el volumen
		} else if (button == Button.SIX) {
			tv.volumeDown(); // bajar el volumen
		}
	}

	public void show(PrintStream output) {
		output.println();
		output.println("Botones:");
		int buttonNumber = 1;
		for (Button each : Button.values()) {
			output.printf("  %d. %s\n", buttonNumber, getButtonIcon(each));
			buttonNumber++;
		}
		output.println();
	}

	private String getButtonIcon(Button button) {
		switch (button) {
		case ONE:
			return "Encender/apagar el televisor";
		case TWO:
			return "Poner el canal 1 del televisor";
		case THREE:
			return "Poner el canal 3 del televisor";
		case FOUR:
			return "Poner el canal 15 del televisor";
		case FIVE:
			return "Subir el volumen del televisor";
		case SIX:
			return "Bajar el volumen del televisor";
		}
		throw new AssertionError("¡Botón desconocido!: " + button);
	}
}
