package filesystem_students.decorador;

import java.io.IOException;

public class Normalizar implements Output {

	private Output out;

	public Normalizar(Output out) {
		this.out = out;
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\r')
			out.send(c);

	}

	@Override
	public void close() throws IOException {
		out.close();

	}

}
