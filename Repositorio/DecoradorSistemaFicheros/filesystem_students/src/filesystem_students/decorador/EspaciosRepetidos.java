package filesystem_students.decorador;

import java.io.IOException;

public class EspaciosRepetidos implements Output {
	
	private Output out;
	private char lastChar = 0;

	public EspaciosRepetidos(Output out) {
		this.out = out;
	}

	@Override
	public void send(char c) throws IOException {
		if(c == ' ' && lastChar == ' ')
			return;
		out.send(c);
		lastChar = c;

	}

	@Override
	public void close() throws IOException {
		out.close();

	}

}
