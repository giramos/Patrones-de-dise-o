package exam_text_editor_students_v3;

public class ActionReemplazar implements Action {

	private String[] line;
	
	public ActionReemplazar(String[] linea) {
		this.line = linea;
	}

	@Override
	public void execute(Editor editor) {
		editor.reemplazar(line);

	}

}
