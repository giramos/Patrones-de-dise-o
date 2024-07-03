package exam_text_editor_students_v3;

import java.util.HashMap;

public class ActionManager {
	
	Editor editor;
	HashMap<String, Macro>macros ;
	Macro macro;
	boolean grabando;
	
	public ActionManager() {
		macros = new HashMap<String, Macro>();
		editor = new Editor();
	}
	
	public void execute(Action action) {
		action.execute(editor);
		if(grabando)
			macro.añadir(action);
	}

	public void grabar(String line) {
		grabando = true;
		macro = new Macro(line);
	}
	
	public void parar() {
		if(!grabando)
			return;
		grabando = false;
		macros.put(macro.getNombre(), macro);
	}
	
	public void ejecutar(String line) {
		execute(macros.get(line));
	}
}
