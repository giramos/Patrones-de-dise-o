package exam_text_editor_students_v3;

import java.util.List;
import java.util.ArrayList;

public class Macro implements Action {

	List<Action> acciones;
	private String nombre;

	public Macro(String nombre) {
		this.nombre = nombre;
		acciones = new ArrayList<Action>();
	}

	@Override
	public void execute(Editor editor) {
		for (Action a : acciones) {
			a.execute(editor);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void añadir(Action action) {
		acciones.add(action);
	}

}
