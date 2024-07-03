import java.io.IOException;

public class Insertar implements Command {

	String[] line;
	Receptor r;

	public Insertar(String[] line) {
		this.line = line;
	}

	@Override
	public void execute() throws IOException {
		r.insertar(line);
	}

}
