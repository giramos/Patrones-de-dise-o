package dash;

public class ActionNothing implements Action {

	@Override
	public void accion() {
		System.out.println("[Botón sin configurar]");

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "No hacer nada";
	}

}
