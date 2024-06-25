package dash;

public class AccionNothing implements Accion {

	@Override
	public void execute() {
		System.out.println("Acción no reconocida");

	}

	@Override
	public String descipcion() {
		return "Acción no reconocida";
	}

}
