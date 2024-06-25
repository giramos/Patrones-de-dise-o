package dash;

public class ActionTime implements Action {

	@Override
	public void accion() {
		System.out.println("Son las 12:00");
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Decir la hora";
	}

}
