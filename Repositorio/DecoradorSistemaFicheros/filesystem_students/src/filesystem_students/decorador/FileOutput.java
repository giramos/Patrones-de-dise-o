package filesystem_students.decorador;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output {
	
	FileWriter writer;

	public FileOutput(String file) throws IOException {
		 writer = new FileWriter(file);
	}

	@Override
	public void send(char c) throws IOException {
		writer.append(c);		
	}

	@Override
	public void close() throws IOException {
		writer.close();
		
	}

	
}
