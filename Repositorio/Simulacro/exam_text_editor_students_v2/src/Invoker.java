import java.util.HashMap;

public class Invoker {

	Receptor r;
	Macro macro;
	HashMap<String, Macro> macros;
	private boolean grabando;


	public void execute(Action action) {
		action.execute(r);
		if(grabando)
			macro.añadir(action);
	}

	public void grabarMacro(String line) {
		grabando = true;
		macro = new Macro(line);
	}

	public void pararMacro() {
		if (!grabando) {
			return;
		}
		grabando = false;
		macros.put(this.macro.getLine(), this.macro);
	}

	public void ejecutaMacro(String string) {
		this.execute(macros.get(string));

	}
}
