package dash;
public class AccionCoffee implements Accion {

	@Override
	public void execute() {
		System.out.println("Conectando con el servidor...");
		System.out.println("Pedido online realizado de café");
	}

	@Override
	public String descipcion() {
		return "Pedir online café";
		
	}

}
