package dash;

public class ActionNull implements Action {

	@Override
	public void accion() {
		System.out.println("[Botón sin configurar]");

	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "No hacer nada";
	}

}
