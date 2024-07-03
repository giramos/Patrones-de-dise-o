package command.lamp;

import command.Action;
import lamp.Lamp;

public class ActionEncenderLuz implements Action {

	Lamp lamp;

	public ActionEncenderLuz(Lamp lamp) {
		this.lamp = lamp;
	}

	@Override
	public void buttonPressed() {
		lamp.turnOn();

	}

	@Override
	public String getButtonIcon() {
		return "Encender la luz";
	}

}
