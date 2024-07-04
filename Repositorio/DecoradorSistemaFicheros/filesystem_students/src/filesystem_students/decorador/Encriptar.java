package filesystem_students.decorador;

import java.io.IOException;

public class Encriptar implements Output {
	
	private Output out;

	public Encriptar(Output out) {
		this.out = out;
	}

	@Override
	public void send(char c) throws IOException {
		out.send((char) (Character.isLetterOrDigit(c) ? c + 1 : c));

	}

	@Override
	public void close() throws IOException {
		out.close();

	}

}
