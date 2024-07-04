package filesystem_students.decorador;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Composite implements Output {
	
	private List<Output> coleccion;

	public Composite(Output...outputs) {
		this.coleccion = Arrays.asList(outputs);
	}

	@Override
	public void send(char c) throws IOException {
		for(Output out: coleccion) {
			out.send(c);
		}

	}

	@Override
	public void close() throws IOException {
		for(Output out: coleccion) {
			out.close();
		}
	}

}
