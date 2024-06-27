package dash;

public class ActionGillette implements Action {

	@Override
	public void accion() {
		System.out.println("Conectando con el servidor...");
        System.out.println("Pedido online realizado de Gillete");

	}

	@Override
	public String descripcion() {
		// TODO Auto-generated method stub
		return  "Pedir online Gillette";
	}

}
