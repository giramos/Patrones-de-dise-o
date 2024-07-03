package main;

import java.io.*;

public class InterfazDeUsuario {

	public InterfazDeUsuario(Controlador controlador) {
		this.controlador = controlador;
	}

	public void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Pulse un número del 1 al 4 o exit");

		do {
			System.out.print(">");
			String[] line = in.readLine().split("[ ,]");

			if (line[0].equals("exit"))
				return;
			else if (line[0].equals("1"))
				controlador.pulsadaColumnaRanking();
			else if (line[0].equals("2"))
				controlador.pulsadaColumnaNombre();
			else if (line[0].equals("3"))
				controlador.pulsadaColumnaMedia();
			else if (line[0].equals("4"))
				controlador.pulsadaColumnaVotos();
			else
				System.out.println("Comando no válido");

		} while (true);
	}

	private BufferedReader in;
	private Controlador controlador;
}
