package dash;

public class AccionTime implements Accion {

	@Override
	public void execute() {
		System.out.println("Son las 12:00");

	}

	@Override
	public String descipcion() {
		// TODO Auto-generated method stub
		return "Decir la hora";
	}

}
