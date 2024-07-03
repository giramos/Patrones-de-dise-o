package command.tv;

import command.Action;
import tv.TV;

public class ActionCambiarCanal implements Action {
	TV tv;
	int canal;
	
	public ActionCambiarCanal(TV tv, int channel) {
		this.canal = channel;
		this.tv = tv;
	}

	@Override
	public void buttonPressed() {
		tv.setChannel(canal);

	}

	@Override
	public String getButtonIcon() {
		return "Poner el canal " + canal + " del televisor";
	}

}
