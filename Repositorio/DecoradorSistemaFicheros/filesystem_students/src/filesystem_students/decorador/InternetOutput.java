package filesystem_students.decorador;

import java.io.IOException;
import java.io.StringWriter;

public class InternetOutput implements Output {
	StringWriter stringWriter;
	public InternetOutput(String str){
		 stringWriter = new StringWriter();
		stringWriter.append("\n--- START Internet [" + str + "]\n");
	}

	@Override
	public void send(char c) throws IOException {
		stringWriter.append(c);

	}

	@Override
	public void close() throws IOException {
		System.out.println(stringWriter.toString());
		System.out.println("--- END   Internet");

	}

}
