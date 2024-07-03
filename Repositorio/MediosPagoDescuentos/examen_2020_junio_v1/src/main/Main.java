package main;

import machine.*;
import machine.estrategia.Efectivo;
import machine.estrategia.PayPal;
import machine.estrategia.Tarjeta;
import machine.model.Event;
import machine.promocion.Fijo;
import machine.promocion.Gratis;
import machine.promocion.Nada;
import machine.promocion.Porcentaje;

// El main sólo debería ser modificado para crear nuevos objetos que formen
// parte de la solución.
//
public class Main {
	public static void main(String[] args) {
		Machine machine = new Machine();

		// se introducen medios de pago en la máquina expendedora
		machine.addMedios(new Efectivo());
		machine.addMedios(new Tarjeta());
		machine.addMedios(new PayPal());

		// se introducen unos eventos en la máquina expendedora
		machine.addEvent(new Event("Concierto de los Rolling Stones", 120, 5));
		machine.addEvent(new Event("Cartelera: Blade runner", 10, 100));
		machine.addEvent(new Event("Actuación de Rubén García", 60, 80));
		machine.addEvent(new Event("Concierto de la OSPA", 90, 30));
		machine.addEvent(new Event("Ópera: Nabuco", 160, 20));

		// se introducen medios de pago en la máquina expendedora
		machine.addDescuentos(new Fijo(15));
		machine.addDescuentos(new Porcentaje(10));
		machine.addDescuentos(new Gratis());
		machine.addDescuentos(new Nada());

		// se cede el control de la ejecución a la máquina
		machine.run();
	}
}
