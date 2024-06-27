package dash;

public class ActionTime implements Action {

	@Override
	public void accion() {
		System.out.println("Son las 12:00");

	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Decir la hora";
	}

}
