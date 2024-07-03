package command;

import java.util.List;
import java.util.ArrayList;

public class ActionNoImplementado implements Action {
	
	List<Action> acciones;
	String str;
	
	public ActionNoImplementado(List<Action> lista) {
		this.acciones = lista;
	}

	public ActionNoImplementado() {
		acciones = new ArrayList<>();	}

	public ActionNoImplementado(String string, List<Action> acciones2) {
		str = string;
		this.acciones = acciones2;
	}

	@Override
	public void buttonPressed() {
		for(Action a: acciones) {
			a.buttonPressed();
		}

	}

	@Override
	public String getButtonIcon() {
		return "Noche";
	}

}
