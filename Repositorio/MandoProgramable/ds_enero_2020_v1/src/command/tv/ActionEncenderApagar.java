package command.tv;

import command.Action;
import tv.TV;

public class ActionEncenderApagar implements Action {

	TV tv;
	
	public ActionEncenderApagar(TV tv) {
		this.tv = tv;
	}

	@Override
	public void buttonPressed() {
		if (tv.isOn()) {
			tv.turnOff();
		}
		tv.turnOn();

	}

	@Override
	public String getButtonIcon() {
		return "Encender/apagar el televisor";
	}

}
