import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Receptor {

	static StringBuilder texto;
	Invoker invoke;
	
	public Receptor() {
		texto = new StringBuilder("");
		invoke = new Invoker();
	}

	static void reemplazar(String[] line) {
		texto = new StringBuilder(texto.toString().replaceAll(Pattern.quote(line[1]), line[2]));
	}

	static void borrar() {
		int indexOfLastWord = texto.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			texto = new StringBuilder("");
		else
			texto.setLength(indexOfLastWord + 1);
	}

	static void insertar(String[] line) {
		for (int i = 1; i < line.length; i++) {
			texto.append(line[i] + " ");
		}
	}

	static void abrir(String[] line) throws IOException {
		texto = readFile(line[1]);
	}

	static StringBuilder readFile(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}

	public static StringBuilder getTexto() {
		return texto;
	}

	public static void setTexto(StringBuilder texto) {
		Receptor.texto = texto;
	}
	
	public void grabar(String str) {
		invoke.grabarMacro(str);
	}
	
	public void parar() {
		invoke.pararMacro();
	}
	
	public void ejecuta(String str) {
		invoke.ejecutaMacro(str);
	}

}
