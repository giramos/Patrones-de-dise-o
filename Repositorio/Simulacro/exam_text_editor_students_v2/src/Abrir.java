import java.io.IOException;

public class Abrir implements Action {
	String[] line;

	public Abrir(String[] line2) {
		this.line = line2;
	}

	@Override
	public void execute(Receptor r) {
		try {
			r.abrir(line);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
