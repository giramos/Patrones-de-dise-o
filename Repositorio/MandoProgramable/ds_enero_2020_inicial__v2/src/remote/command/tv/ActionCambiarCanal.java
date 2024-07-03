package remote.command.tv;

import remote.Action;
import tv.TV;

public class ActionCambiarCanal implements Action {

	TV tv;
	private int canal;

	public ActionCambiarCanal(TV tv2, int canal) {
		this.canal = canal;
		this.tv = tv2;
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
