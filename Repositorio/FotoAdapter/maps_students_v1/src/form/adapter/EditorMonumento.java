package form.adapter;

import form.Consola;
import form.Editor;
import model.Monument;

public class EditorMonumento implements Editor {

	Monument monument;
	Consola consola;
	
	public EditorMonumento(Monument m) {
		this.monument = m;
		this.consola = new Consola();
	}
	
	@Override
	public void pintar() {
		System.out.println(" - Autor: " + monument.getAuthor());
		System.out.println(" - Dirección: " + monument.getAddress());

	}

	@Override
	public void editar() {
		System.out.println("Editando el monumento...");

		System.out.println("Valores actuales:");
		pintar();

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.print(" - Autor: ");
		String value = consola.readLine();
		if (value.length() > 0)
			monument.setAuthor(value);

		System.out.print(" - Dirección: ");
		value = consola.readLine();
		if (value.length() > 0)
			monument.setAddress(value);

		System.out.println("Valores finales:");
		pintar();

	}

}
