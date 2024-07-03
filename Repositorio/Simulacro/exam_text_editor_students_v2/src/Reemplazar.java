
public class Reemplazar implements Action {
	
	String[] line;

	public Reemplazar(String[] line) {
		this.line = line;
	}

	@Override
	public void execute(Receptor r) {
		r.reemplazar(line);

	}

}
