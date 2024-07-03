package main;
import java.util.*;
import java.io.IOException;

// dispositivos
import airconditioning.AirConditioner;
import lamp.Lamp;
import tv.TV;

import remote.*;
import remote.command.tv.ActionBajarVolumen;
import remote.command.tv.ActionCambiarCanal;
import remote.command.tv.ActionEncenderTV;
import remote.command.tv.ActionSubirVolumen;
import remote.ui.ButtonController;

public class Main {
	private Remote remote = new Remote();
	private ButtonController controller = new ButtonController(remote);

	// los distintos dispositivos con los que interactúa el mando
	private Lamp lamp = new Lamp();
	private AirConditioner airConditioner = new AirConditioner();
	private TV tv = new TV();

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	private void run() throws IOException {

		 config1();
		// config2();
		// config3();

		controller.run();

		// al terminar muestra el estado de los distintos dispositivos
		printDeviceStatus();
	}

	private void config1() {
		/*
		 * 1. Encender/apagar el televisor 2. Poner el canal 1 del televisor 3. Poner el
		 * canal 3 del televisor 4. Poner el canal 15 del televisor 5. Subir el volumen
		 * del televisor 6. Bajar el volumen del televisor
		 */
		List<Action> acciones = new ArrayList<>();
		acciones.add(new ActionEncenderTV(tv));
		acciones.add(new ActionCambiarCanal(tv,1));
		acciones.add(new ActionCambiarCanal(tv,3));
		acciones.add(new ActionCambiarCanal(tv,15));
		acciones.add(new ActionSubirVolumen(tv));
		acciones.add(new ActionBajarVolumen(tv));
		remote = new Remote(acciones);
		controller.setRemote(remote);

	}

	private void config2() {
		/*
		 * 1. Encender la luz 2. Apagar el aire acondicionado 3. Poner el canal 1 del
		 * televisor 4. Poner el aire acondicionado a baja potencia 5. -- 6. Poner el
		 * aire acondicionado a alta potencia
		 */
	}

	private void config3() {
		config2();
		// Hacer que el botón 5 ("Noche") haga lo siguiente:
		// - Bajar dos veces consecutivas el volumen del televisor
		// - Apagar el aire acondicionado
		// - Apagar la luz
	}

	private void printDeviceStatus() {
		System.out.println();
		System.out.println("---------------------------------");
		System.out.println(tv);
		System.out.println(lamp);
		System.out.println(airConditioner);
		System.out.println("---------------------------------");
	}
}
