package filesystem_students.decorador;

import java.io.IOException;

public class Contador implements Output {

	private Output out;
	private int counter;

	public Contador(Output out) {
		this.out = out;
	}

	@Override
	public void send(char c) throws IOException {
		out.send(c);
		counter = getCounter() + 1;

	}

	@Override
	public void close() throws IOException {
		out.close();
	}

	public int getCounter() {
		return counter;
	}

}
