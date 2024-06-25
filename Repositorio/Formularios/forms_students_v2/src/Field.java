import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Estrategia.Validacion;

public class Field {

	private String label;
	private String value;
	private Validacion validator;

	public Field(String texto, Validacion v) {
		this.label = texto;
		this.validator = v;
	}

	public void askUser() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {
				System.out.print(label + ": ");
				value = console.readLine();
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!validator.isValid(value));
	}

	public String getValue() {
		return value;
	}
}
