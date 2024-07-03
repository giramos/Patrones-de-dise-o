package remote.command.tv;

import remote.Action;
import tv.TV;

public class ActionBajarVolumen implements Action {

	TV tv;
	
	public ActionBajarVolumen(TV tv2) {
		this.tv = tv2;
	}

	@Override
	public void buttonPressed() {
		tv.volumeUp();
	}

	@Override
	public String getButtonIcon() {
		return "Bajara el volumen del televisor";
	}

}
