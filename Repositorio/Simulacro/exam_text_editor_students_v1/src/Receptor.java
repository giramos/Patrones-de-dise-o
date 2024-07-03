import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Receptor {
	
	static StringBuilder texto;
	
	public Receptor() {
		texto = new StringBuilder("");
	}

	static void borrar() {
		int indexOfLastWord = texto.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			texto = new StringBuilder("");
		else
			texto.setLength(indexOfLastWord + 1);
	}

	static void reemplazar(String[] line) {
		texto = new StringBuilder(texto.toString().replaceAll(Pattern.quote(line[1]), line[2]));
	}

	static void insertar(String[] line) {
		for (int i = 1; i < line.length; i++) {
			texto.append(line[i] + " ");
		}
	}

	static void abrir(String[] line) throws IOException {
		texto = readFile(line[1]);
	}

	static StringBuilder readFile(String filename) throws IOException 
	{
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}

}
