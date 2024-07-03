package remote.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import remote.Remote;

//Esta clase representa el controlador del mando, quien recibe la pulsación
//de los botones y se encarga de invocar al método buttonPressed del mando
//(Remote) indicándole qué botón ha sido pulsado. (En nuestro caso se simula
//con un menú de texto por consola.)
//
public class ButtonController {
	private Remote remote;
	private BufferedReader input;
	private PrintStream output = System.out;

	public ButtonController(Remote remote) {
		this.remote = remote;
		input = new BufferedReader(new InputStreamReader(System.in));
	}

	public void run() throws IOException {
		while (true) {
			remote.show(output);
			output.println("Pulse uno de los botones del mando ([S] para salir):");
			output.print("> ");
			output.flush();
			String userInput = input.readLine();

			if (userInput.trim().toUpperCase().equals("S")) {
				output.println("¡Adiós!");
				return;
			}
			// si no era la opción de salir tiene que ser una pulsación de un botón
			try {
				int buttonNumber = Integer.parseInt(userInput);
				if (buttonNumber < 1 || buttonNumber > 6) {
					output.println("Se esperaba un número de botón (entre 1 y 6)");
				} else {
					remote.buttonPressed(buttonNumber);
				}
			} catch (NumberFormatException e) {
				output.println("Se esperaba un número de botón");
			} catch (Exception e) {
				output.println(e.getMessage());
			}
		}
	}

	public void setRemote(Remote remote2) {
		remote = remote2;
		
	}
}
