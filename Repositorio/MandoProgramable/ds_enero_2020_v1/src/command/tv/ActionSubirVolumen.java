package command.tv;

import command.Action;
import tv.TV;

public class ActionSubirVolumen implements Action {

	TV tv;

	public ActionSubirVolumen(TV tv) {
		this.tv = tv;
	}

	@Override
	public void buttonPressed() {
		tv.volumeUp();
	}

	@Override
	public String getButtonIcon() {
		return "Subir el volumen del televisor";
	}

}
