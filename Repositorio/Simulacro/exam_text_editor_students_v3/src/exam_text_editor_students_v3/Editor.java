package exam_text_editor_students_v3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Editor {

	public static StringBuilder texto;

	public Editor() {
		texto = new StringBuilder("");
	}

	public static void reemplazar(String[] line) {
		 texto = new StringBuilder( texto.toString().replaceAll(Pattern.quote(line[1]), line[2]));
	}

	public static void borrar() {
		int indexOfLastWord =  texto.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			 texto = new StringBuilder("");
		else
			 texto.setLength(indexOfLastWord + 1);
	}

	public static void insertar(String[] line) {
		for (int i = 1; i < line.length; i++) {
			 texto.append(line[i] + " ");
		}
	}

	public static void abrir(String[] line) throws IOException {
		 texto =  readFile(line[1]);
	}

	public static StringBuilder readFile(String filename) throws IOException {
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
	
	static ActionManager am = new ActionManager();
	
	public void grabar(String line) {
		am.grabar(line);
	}
	
	public void parar() {
		am.parar();
	}
	
	public void ejecutarMacro(String line) {
		am.ejecutar(line);
	}

}
