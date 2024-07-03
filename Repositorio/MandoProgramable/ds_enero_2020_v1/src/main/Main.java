package main;

import command.Action;
import command.ActionNoImplementado;
import command.aire.ActionCambiarAirePotencia;
import command.lamp.ActionApagarLuz;
import command.lamp.ActionEncenderLuz;
import command.tv.ActionBajarVolumen;
import command.tv.ActionCambiarCanal;
import command.tv.ActionEncenderApagar;
import command.tv.ActionSubirVolumen;

import java.io.IOException;
import java.util.*;

// dispositivos
import airconditioning.AirConditioner;
import airconditioning.AirConditioner.Mode;
import lamp.Lamp;
import tv.TV;

import remote.*;

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

//		 config1();
//		 config2();
		 config3();

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
		List<Action> acciones = new ArrayList<Action>();
		acciones.add(new ActionEncenderApagar(tv));
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
		List<Action> acciones = new ArrayList<Action>();
		acciones.add(new ActionEncenderLuz(lamp));
		acciones.add(new ActionCambiarAirePotencia(airConditioner,Mode.OFF));
		acciones.add(new ActionCambiarCanal(tv,1));
		acciones.add(new ActionCambiarAirePotencia(airConditioner,Mode.LOW));
		acciones.add(new ActionNoImplementado());
		acciones.add(new ActionCambiarAirePotencia(airConditioner,Mode.HIGH));
		remote = new Remote(acciones);
		controller.setRemote(remote);
	}

	private void config3() {
		config2();
		List<Action>acciones = new ArrayList<Action>();
		acciones.add(new ActionBajarVolumen(tv));
		acciones.add(new ActionBajarVolumen(tv));
		acciones.add(new ActionCambiarAirePotencia(airConditioner, Mode.OFF));
		acciones.add(new ActionApagarLuz(lamp));
		ActionNoImplementado noche = new ActionNoImplementado("noche",acciones);
		remote.addAction(5, noche);
		controller.setRemote(remote);

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
