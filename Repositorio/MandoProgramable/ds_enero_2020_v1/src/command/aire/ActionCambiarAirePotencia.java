package command.aire;

import airconditioning.AirConditioner;
import airconditioning.AirConditioner.Mode;
import command.Action;

public class ActionCambiarAirePotencia implements Action {
	AirConditioner aire;
	Mode modo;
	
	public ActionCambiarAirePotencia(AirConditioner airConditioner, Mode mod) {
		aire = airConditioner;
		modo = mod;
	}

	@Override
	public void buttonPressed() {
		aire.setMode(modo);
	}

	@Override
	public String getButtonIcon() {
		if (modo == Mode.OFF) {
			return "Apagar el aire acondicionado";
		} else if (modo == Mode.HIGH) {
			return "Subir el aire acondicionado";
		} else {
			return "Bajar el aire acondicionado";
		}
		
	}

}
