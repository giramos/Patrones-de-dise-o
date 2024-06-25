import Estrategia.ValidacionNumero;
import Estrategia.ValidacionTexto;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new Field("Nombre", new ValidacionTexto()));
		form.addField(new Field("Apellido", new ValidacionTexto()));
		form.addField(new Field("Teléfono", new ValidacionNumero()));
		form.addField(new Field("Ciudad", new ValidacionPredefinidos( "Santander", "Oviedo", "Cádiz")));

		form.askUser();
	}
}
