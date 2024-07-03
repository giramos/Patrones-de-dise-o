import java.util.*;

public class Macro implements Action {
	List<Action> acciones ;
	private String line;

	public Macro(List<Action> lista) {
		this.acciones = lista;
	}

	public Macro(String line) {
		this.line = line;
		this.acciones = new ArrayList<Action>();
	}

	@Override
	public void execute(Receptor r) {
		for (Action a : acciones) {
			a.execute(r);
		}

	}

	public void añadir(Action a) {
		acciones.add(a);
	}

	public void borrar(Action a) {
		acciones.remove(a);
	}

	public String getLine() {
		return line;
	}

}
