package exam_text_editor_students_v3;

import java.io.IOException;

public class ActionAbrir implements Action {

	String[] line;
	
	public ActionAbrir(String[] line) {
		this.line = line;
	}
	@Override
	public void execute(Editor editor) {
		try {
			editor.abrir(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
