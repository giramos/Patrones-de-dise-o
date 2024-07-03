package remote;

import java.io.PrintStream;
import java.util.*;

public class Remote {
//	public enum Button {
//		ONE, TWO, THREE, FOUR, FIVE, SIX
//	}

	List<Action> acciones;

	public Remote(List<Action> acciones2) {
		acciones = acciones2;
	}

	public Remote() {
		// TODO Auto-generated constructor stub
	}

	public void buttonPressed(int button) {
		acciones.get(button - 1).buttonPressed();
	}

	public void show(PrintStream output) {
		output.println();
		output.println("Botones:");
		int buttonNumber = 1;
		for (Action each : acciones) {
			output.printf("  %d. %s\n", buttonNumber, getButtonIcon(each));
			buttonNumber++;
		}
		output.println();
	}

	private String getButtonIcon(Action action) {
		return action.getButtonIcon();
	}
}
