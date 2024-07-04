import java.io.*;

import filesystem_students.decorador.BluetoothOutput;
import filesystem_students.decorador.Composite;
import filesystem_students.decorador.Encriptar;
import filesystem_students.decorador.EspaciosRepetidos;
import filesystem_students.decorador.FileOutput;
import filesystem_students.decorador.InternetOutput;
import filesystem_students.decorador.Normalizar;
import filesystem_students.decorador.Contador;

public class Main {
	public static void main(String[] args) throws IOException {
		FileSystem system = new FileSystem();

		system.copyFile("privado.txt", new FileOutput("copia.txt"));
		system.copyFile("privado.txt", new InternetOutput("156.17.11.196"));
		system.copyFile("privado.txt", new BluetoothOutput("Galaxy de Raúl"));

		system.copyFile("privado.txt", new Normalizar(new FileOutput("copia.txt")));
		system.copyFile("privado.txt", new Encriptar(new InternetOutput("156.17.11.196")));
		system.copyFile("privado.txt", new EspaciosRepetidos((new Encriptar(new BluetoothOutput("Galaxy de Raúl")))));

		system.copyFile("privado.txt", new Normalizar(new FileOutput("a.txt")));
		system.copyFile("privado.txt", new Encriptar(new Normalizar(new FileOutput("b.txt"))));

		system.copyFile("privado.txt", new Composite(new Encriptar(new InternetOutput("156.17.11.196")),
				new Encriptar(new BluetoothOutput("Galaxy de Raúl"))));
		
		// contar caracteres escritos
		Contador counter = new Contador(new InternetOutput("1.1.1.1"));
		system.copyFile("privado.txt", new EspaciosRepetidos(counter));
		System.out.println("Contar caracteres escritos: " + counter.getCounter());
		
		//Poder contar caracteres tambi�n antes de normalizar
		Contador despues = new Contador((new InternetOutput("1.1.1.1")));
		Contador antes = new Contador(new EspaciosRepetidos(despues));
		system.copyFile("privado.txt", antes);
		System.out.println("Contar caracteres escritos antes y después: " + antes.getCounter() + " -> "
				+ despues.getCounter());


	}
}
