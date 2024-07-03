package command.tv;

import command.Action;
import tv.TV;

public class ActionBajarVolumen implements Action{

	TV tv;
	
	public ActionBajarVolumen(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void buttonPressed() {
		tv.volumeDown();
	}

	@Override
	public String getButtonIcon() {
		return "Bajar el volumen del televisor";
	}

}
