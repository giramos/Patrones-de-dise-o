package remote;

import java.io.PrintStream;
import java.util.*;

import command.Action;
import command.ActionNoImplementado;

public class Remote {
	List<Action> acciones;

	public Remote(List<Action> acciones2) {
		acciones = acciones2;
	}

	public Remote() {
		// TODO Auto-generated constructor stub
	}

	public void buttonPressed(int buttonNumber) {
		acciones.get(buttonNumber - 1).buttonPressed();
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

	public void addAction(int i, ActionNoImplementado noche) {
		acciones.remove(i - 1);
		acciones.add(i - 1, noche);
	}
}
