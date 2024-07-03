import java.io.IOException;

public class Abrir implements Command {

	Receptor r;
	String[] line;

	public Abrir(String[] line2) {
		this.line = line2;
	}

	@Override
	public void execute() throws IOException {
		r.abrir(line);
	}

}
