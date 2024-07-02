package form.main;

import form.Consola;
import form.Editor;
import model.Photo;

public class EditorFoto implements Editor {

	Photo f;
	Consola consola;

	public EditorFoto(Photo f) {
		this.f = f;
		this.consola = new Consola();
	}

	@Override
	public void pintar() {
		System.out.println(" - Usuario: " + f.getUser());
		System.out.println(" - Descripcion: " + f.getDescription());

	}

	@Override
	public void editar() {
		System.out.println("Editando la foto...");

		System.out.println("Valores actuales:");
		pintar();

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.print(" - Usuario: ");
		String value = consola.readLine();
		if (value.length() > 0)
			f.setUser(value);

		System.out.print(" - Descripción: ");
		value = consola.readLine();
		if (value.length() > 0)
			f.setDescription(value);

		System.out.println("Valores finales:");
		pintar();

	}

}
