package form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consola {

	public String readLine() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				return console.readLine();
			} catch (IOException ex) {
				System.out.println("Error de lectura: inténtelo de nuevo");
			}
		} while (true);
	}
}
