package remote.command.tv;

import remote.Action;
import tv.TV;

public class ActionSubirVolumen implements Action {

	TV tv;
	
	public ActionSubirVolumen(TV tv2) {
		this.tv = tv2;
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
