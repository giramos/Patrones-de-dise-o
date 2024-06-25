import Estrategia.ValidacionCantidadMayor;
import Estrategia.ValidacionCantidadMenor;
import Estrategia.ValidacionLongitud;
import Estrategia.ValidacionNumero;
import Estrategia.ValidacionPredefinidos;
import Estrategia.ValidacionTexto;
import Estrategia.Composite.ValidacionAll;
import Estrategia.Composite.ValidacionAny;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		// parte estrategia
		
		form.addField(new Field("Nombre", new ValidacionTexto()));
		form.addField(new Field("Apellido", new ValidacionTexto()));
		form.addField(new Field("Teléfono", new ValidacionNumero()));
		form.addField(new Field("Ciudad", new ValidacionPredefinidos( "Santander", "Oviedo", "Cádiz")));
		form.addField(new Field("Código de Producto", new ValidacionLongitud(4)));
		
		// parte composite
		form.addField(new Field("Código postal", new ValidacionAll(new ValidacionLongitud(5), new ValidacionNumero())));
		form.addField(new Field("Edad", new ValidacionAll(new ValidacionNumero(), new ValidacionCantidadMayor(18))));
		form.addField(new Field("Sueldo", new ValidacionAll(new ValidacionNumero(), new ValidacionCantidadMayor(800), new ValidacionCantidadMenor(1200))));
		form.addField(new Field("Ubicacion", new ValidacionAny(new ValidacionPredefinidos( "Santander", "Oviedo", "Cádiz"),new ValidacionAll(new ValidacionLongitud(5), new ValidacionNumero()))));
		form.addField(new Field("Código de Promoción", new ValidacionAny(new ValidacionTexto(), new ValidacionLongitud(3))));

		
		form.askUser();
	}
}
