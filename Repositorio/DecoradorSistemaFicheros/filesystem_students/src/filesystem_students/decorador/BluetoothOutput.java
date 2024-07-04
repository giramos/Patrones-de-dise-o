package filesystem_students.decorador;

import java.io.IOException;
import java.io.StringWriter;

public class BluetoothOutput implements Output {
	StringWriter stringWriter;

	public BluetoothOutput(String device) {
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START Bluetooth [" + device + "]\n");
	}

	@Override
	public void send(char c) throws IOException {
		stringWriter.append(c);
	}

	@Override
	public void close() throws IOException {
		System.out.println(stringWriter.toString());
		System.out.println("--- END   Bluetooth");

	}

}
