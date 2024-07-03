
public class Insertar implements Action {
	String[] line;

	public Insertar(String[] line) {
		this.line = line;
	}

	@Override
	public void execute(Receptor r) {
		r.insertar(line);

	}

}
