package exam_text_editor_students_v3;

public class ActionInsertar implements Action {

	private String[] linea;

	public ActionInsertar(String[] linea) {
		this.linea = linea;
	}
	@Override
	public void execute(Editor editor) {
		editor.insertar(linea);

	}

}
