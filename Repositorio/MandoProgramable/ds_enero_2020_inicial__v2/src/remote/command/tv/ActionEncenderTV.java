package remote.command.tv;

import remote.Action;
import tv.TV;

public class ActionEncenderTV implements Action {

	TV tv;
	
	public ActionEncenderTV(TV tv2) {
		this.tv = tv2;
	}

	@Override
	public void buttonPressed() {
		if(tv.isOn()) {
			tv.turnOff();
		}
		tv.turnOn();

	}

	@Override
	public String getButtonIcon() {
		return "Encender/apagar el televisor";
	}

}
