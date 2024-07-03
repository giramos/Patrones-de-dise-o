import java.io.*;
import java.util.regex.*;

import exam_text_editor_students_v3.ActionAbrir;
import exam_text_editor_students_v3.ActionBorrar;
import exam_text_editor_students_v3.ActionInsertar;
import exam_text_editor_students_v3.ActionManager;
import exam_text_editor_students_v3.ActionReemplazar;
import exam_text_editor_students_v3.Editor;

public class Main 
{
	private static BufferedReader in;
	private static ActionManager invoke;
	

	public static void main(String[] args) throws IOException 
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		invoke = new ActionManager();
		
		System.out.println("Acciones");
		System.out.println("--------");
		System.out.println("abre <fichero>");
		System.out.println("inserta <texto>\t\t// inserta las palabras al final del texto");
		System.out.println("borra\t\t\t// borra la última palabra");
		System.out.println("reemplaza <a> <b>\t// reemplaza la cadena <a> por la <b> en todo el texto");
		System.out.println("salir");
		System.out.println();
		System.out.println("Tareas");
		System.out.println("------");
		System.out.println("graba <macro>\t\t// comienza la grabación de una macro");
		System.out.println("para\t\t\t// finaliza la grabación");
		System.out.println("ejecuta <macro>\t\t// ejecuta la macro cuyo nombre se indique");
		System.out.println();

		do {
			System.out.print("> ");

			String[] line = in.readLine().split(" ");
			
			// No se comprueba que el número de palabras sea el adecuado

			if (line[0].equals("salir"))
				return;

			if (line[0].equals("abre")) {
				invoke.execute(new ActionAbrir(line));
			} else if (line[0].startsWith("ins")) {
				invoke.execute(new ActionInsertar(line));
			} else if (line[0].startsWith("borr")) {
				invoke.execute(new ActionBorrar());
			} else if (line[0].startsWith("reem")) {
				invoke.execute(new ActionReemplazar(line));
			} else if (line[0].startsWith("graba")) {
				invoke.grabar(line[1]);
			} else if (line[0].startsWith("para")) {
				invoke.parar();
			} else if (line[0].startsWith("ejecuta")) {
				invoke.ejecutar(line[1]);
			} else {
				System.out.println("Instrucción desconocida");
			}

			System.out.println(Editor.getTexto());
			
		} while (true);
	}
}
