package dash;
public class AccionGillette implements Accion {

	@Override
	public void execute() {
		System.out.println("Conectando con el servidor...");
        System.out.println("Pedido online realizado de Gillete");
	}

	@Override
	public String descipcion() {
		return "Pedir online Gillette";
	}

}
