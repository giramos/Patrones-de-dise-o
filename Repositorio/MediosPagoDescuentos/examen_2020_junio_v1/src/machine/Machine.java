package machine;

import java.util.ArrayList;
import java.util.List;

import machine.estrategia.MediosPago;
import machine.hardware.Display;
import machine.hardware.Keyboard;
import machine.hardware.Printer;
import machine.model.Event;
import machine.model.Ticket;
import machine.promocion.Descuentos;

public class Machine {

	private List<Event> events = new ArrayList<>();
	private List<MediosPago> medios = new ArrayList<>();
	private List<Descuentos> descuentos = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();

	// -- Métodos públicos
	// -------------------------------------------------------------------------

	public void addEvent(Event event) {
		events.add(event);
	}

	public void addMedios(MediosPago medio) {
		medios.add(medio);
	}

	public void addDescuentos(Descuentos desc) {
		descuentos.add(desc);
	}

	public void run() {
		while (true) {
			// Eventos
			Event selectedEvent = selectEvent();

			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));

			// Promoción
			Descuentos descuento = selectDescuento();

			// se realiza el descuento
			double isValidDescuento = descuento.descontar(amountToPay);

			if (isValidDescuento < 0) {
				display.show("No se ha podido completar el descuento\n\n");
				continue;
			}

			// Medios de pago
			MediosPago paymentMode = selectPaymentMode();

			// se realiza el pago
			boolean isValidPayment = paymentMode.pago(isValidDescuento);

			if (!isValidPayment) {
				display.show("No se ha podido completar el pago\n\n");
				continue;
			}

			// se generan las entradas
			List<Ticket> tickets = selectedEvent.generateTickets(numberOfTickets);

			// por último, la máquina imprime las entradas generadas
			display.show("\nSus entradas se están imprimiendo...\n");
			for (Ticket ticket : tickets) {
				printer.printTicket(ticket);
			}

			display.show("Gracias por su compra, que disfrute del evento.\n\n");
		}
	}

	// -- Pago
	// -------------------------------------------------------------------------

	private Descuentos selectDescuento() {
		display.show("\nEscoja un descuento:\n");
		int i = 1;
		for (Descuentos each : descuentos) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
		int option = keyboard.readOption(descuentos.size());
		Descuentos des = descuentos.get(option - 1);
		display.show("Descuento seleccionado:\n");
		display.show("  " + des.getName() + "\n");
		return des;
	}

	private MediosPago selectPaymentMode() {
		showMedios();
		int option = keyboard.readOption(medios.size());
		MediosPago pago = medios.get(option - 1);
		showMedio(pago);
		return pago;
	}

	private void showMedio(MediosPago pago) {
		display.show("Medio de pago seleccionado:\n");
		display.show("  " + pago.getName() + "\n");
	}

	private void showMedios() {
		display.show("\nEscoja un método de pago:\n");
		int i = 1;
		for (MediosPago each : medios) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}

	}

	// -- Seleccionar evento
	// -------------------------------------------------------------------------

	private Event selectEvent() {
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}

	private void showEvents() {
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}

	private void showEvent(Event event) {
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", event.getAvailableTickets(),
				event.getPrice()));
	}

	// -- Pedir el número de entradas
	// -------------------------------------------------------------------------

	private int howManyTickets(int availableTickets) {
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}
}
