package command.lamp;

import command.Action;
import lamp.Lamp;

public class ActionApagarLuz implements Action {

	Lamp lamp;

	public ActionApagarLuz(Lamp lamp) {
		this.lamp = lamp;
	}

	@Override
	public void buttonPressed() {
		lamp.turnOff();

	}

	@Override
	public String getButtonIcon() {
		return "Apagar la luz";
	}

}
