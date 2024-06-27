package dash;

public class ActionNoReconocida implements Action {

	@Override
	public void accion() {
        System.out.println("Acción no reconocida");

	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return "Acción no reconocida";
	}

}
