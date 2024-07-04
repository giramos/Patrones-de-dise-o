package scooter;

import scooter.components.*;

public class Scooter 
{	
	private static final boolean DEBUG = true;
	
	private static enum Mode { CHARGING, OFF, LOW_BATTERY, DRIVE }
	
	//-- Los componentes internos del patinete
	private Display display = new Display();
	private Battery battery = new Battery();
	private Motor motor = new Motor(battery);
	private Light light = new Light();

	// El tiempo transcurrido y la distancia recorrida desde que se puso en
	// marcha (es decir, desde la última vez que se encendió)
	private int elapsedTime;	// en minutos
	private double distance;	// en metros
	
	private Mode mode = Mode.OFF;
	
	
	// Simula el paso del tiempo, en minutos. Si el patinete está en marcha
	// lo hace mediante una serie de  incrementos sucesivos, de minuto en minuto,
	// para que se puedan hacer comprobaciones intermedias y cambiar de modo si
	// es necesario (por ejemplo, cuando la carga de la batería baja de un cierto
	// nivel o si llega a agotarse por completo antes de finalizar el lapso de
	// tiempo indicado).
	//
	// NOTA: Se recomienda dejar este método en esta clase como está para que
	// ====  funcione correctamente, y cambiar sólo lo necesario en el método
	//       advanceOneMinute(), que es el que depende del modo actual
	//
	public void simulateAdvanceTime(int elapsedTime)
	{
		for (int i = 0; i < elapsedTime; i++) {
			advanceOneMinute(); // incrementos de minuto en minuto
		}
		// después de haber transcurrido el tiempo indicado se actualiza el
		// visor para que muestre información del estado actual del patinete
		showDisplay();
	}	

	//-- Cambio de modo
	//------------------------------------------------------------------------
		
	private void setMode(Mode mode)
	{
		// sólo para depuración, no tiene utilidad práctica
		modeChanged(mode); 
		
		this.mode = mode;
		
		// cada vez que se cambia el modo se actualiza la información de la pantalla
		showDisplay();
	}
	
	//-- MÉTODOS DEPENDIENTES DE CADA MODO
	//-------------------------------------------------------------------------
	
	// Simula que ha transcurrido un minuto. Dependiendo del modo hace una cosa
	// u otra: si está cargando, recargar la batería el equivalente a estar un
	// minuto enchufada; si está en marcha, actualizar el consumo de la batería
	// y la distancia recorridas a la velocidad actual en un minuto, y comprobar
	// al pasar ese minuto el estado de la batería para ver si hay que cambiar a
	// modo de batería baja (velocidad reducida) o apagar el patinete si se
	// agota por completo; etcétera (otros modos nuevos podrían requerir distintas
	// acciones).
	//
	private void advanceOneMinute()
	{
		// si está cargando
		if (mode == Mode.CHARGING) {
			
			// La batería, totalmente descargada, tarda 8 horas y media (510 minutos)
			// en cargarse por completo; así que en un minuto el porcentaje de carga es:
			// 1 minuto * 100 % / 510 minutos = 0.196078431372549
			battery.charge(0.196078431372549);	
		} 
		// si está en marcha
		else if (mode == Mode.LOW_BATTERY || mode == Mode.DRIVE) { 

			motor.updateComsumption(1);
			this.elapsedTime++; 
			// distancia en metros recorrida en un minuto a la velocidad actual:
			double distance = (double) motor.getSpeed() * 1000 / 60;
			this.distance += distance;
			// comprueba la carga de batería restante por si hiciera falta cambiar de modo
			checkBatteryLevel();
		}
	}
	
	// Si la batería se agota mientras el patinete está en marcha, éste se apaga.
	// Por otro lado, si baja de un determinado nivel (según el método isLow de
	// la clase Battery) pasa automáticamente al modo de funcionamiento de batería
	// baja (LOW_BATTERY, con una velocidad máxima reducida).
	//
	private void checkBatteryLevel()
	{
		assert mode == Mode.LOW_BATTERY || mode == Mode.DRIVE :
			"Este método está pensado para ser llamado sólo cuando el patinete está en marcha";

		if (battery.isEmpty()) {
			display.alert("Se agotó la batería: el patinete va a apagarse...");
			// muestra el estado actual del patinete justo antes de apagarse
			showDisplay();
			// se apaga el patinete
			turnOff();	
			setMode(Mode.OFF);
		} else if (mode == Mode.DRIVE && battery.isLow()) {
			display.alert("Cambiando al modo de batería baja...");
			motor.setMaximumSpeed(5);
			setMode(Mode.LOW_BATTERY);
		}
	}
	

	//-- Eventos asociados a las distintas pulsaciones del botón de encendido
	//   (pulsación normal, larga o doble, respectivamente)
	
	public void pressPowerButton()
	{
		if (mode == Mode.OFF) {
			// ¡Ojo!, que no podemos dar por hecho que al ponerlo en marcha cuando
			// está apagado va a pasar siempre al modo de conducción normal (DRIVE):
			// es preciso comprobar primero el nivel de carga de la batería: si es
			// baja se encenderá directamente en modo LOW BATTERY (excepto si la 
			// batería ya está totalmente agotada, en cuyo caso ni siquiera se encenderá,
			// mostrando una advertencia en el visor).
			if (battery.isEmpty()) {
				display.alert("Batería insuficiente: cargue el patinete para poder encenderlo");
				return;
			}
			// si hay batería suficiente para encenderlo, comprobamos en qué modo será
			// (primero hay que poner a cero la distancia y el tiempo y arrancar los componentes)
			turnOn();
			if (battery.isLow()) {
				motor.setMaximumSpeed(5);
				setMode(Mode.LOW_BATTERY);
			} else {
				motor.setMaximumSpeed(25);
				setMode(Mode.DRIVE);
			}
		} else if (mode == Mode.LOW_BATTERY || mode == Mode.DRIVE) {
			// Si está en marcha, en cualquiera de los modos de conducción, una
			// pulsación del botón de encendido enciende o apaga las luces
			if (light.isOn())
				light.turnOff();
			else
				light.turnOn();	
		}
	}
	
	public void longPressPowerButton()
	{
		if (mode == Mode.LOW_BATTERY || mode == Mode.DRIVE) {
			// Si el patinete está en marcha, una pulsación larga lo apaga; pero
			// hay que esperar a que el patinete esté detenido para poder hacerlo,
			// no se puede hacer en movimiento
			if (motor.getSpeed() > 0) {
				display.alert("No se puede apagar el patinete estando en movimiento");
				return;
			}
			turnOff();	
			setMode(Mode.OFF);
		}
	}
	
	public void doublePressPowerButton() 
	{
		// Ahora mismo no hace nada
	}	

	
	//-- Indica que se ha girado el acelerador y cuánto (expresado como el
	//   porcentaje de giro, que debe ser por tanto un número entre 0 y 100,
	//   donde cero detiene el patinete y cien lo pone a su velocidad máxima
	//   actual, dependiendo del modo de conducción actual y del nivel de
	//   carga de la batería).
	
	public void turnAccelerator(int amount)
	{
		// Sólo tiene efecto cuando el patinete está en marcha
		if (mode == Mode.LOW_BATTERY || mode == Mode.DRIVE) {
			motor.accelerate(amount);
		}
	}
	
	
	//-- Enchufar y desenchufar el patinete a la red eléctrica para cargarlo	
	
	public void plugPowerAdapter()
	{
		if (mode == Mode.CHARGING) 
			throw new IllegalStateException("¡¿Cómo se va a recibir esta llamada si ya está enchufado?!");
		
		if (mode != Mode.OFF) {
			display.alert("¡Apague el patinete para poder cargarlo!");
			return;
		}
		setMode(Mode.CHARGING);
	}
	
	public void unplugPowerAdapter()
	{
		if (mode != Mode.CHARGING)
			throw new IllegalStateException("¡¿Cómo se va a desenchufar sin estar enchufado?!");
		
		setMode(Mode.OFF);
	}
	
	
	//-- Actualiza la información mostrada en la pantalla, dependiendo del modo
	public void showDisplay()
	{
		if (mode == Mode.OFF)
			return;
		if (mode == Mode.CHARGING) {
			display.charging(getBatteryLevel());
		} else { // (si está en marcha) 	
			
			// modo de marcha a mostrar en la pantalla
			String drivingMode = "";
			if (mode == Mode.LOW_BATTERY)
				drivingMode = "LOW";
			else if (mode == Mode.DRIVE)
				drivingMode = "D";
			
			display.show(getSpeed(), distance, elapsedTime, drivingMode, light.isOn(), getBatteryLevel());
		}
	}

	
	//-- Métodos públicos de acceso al estado interno del patinete
	//------------------------------------------------------------

	public int getSpeed()					{ return motor.getSpeed(); }
	public double getDistance()				{ return distance; }
	public int getElapsedTime()				{ return elapsedTime; }		
	public double getBatteryLevel()			{ return battery.getLevel(); }
	public boolean isLightOn()				{ return light.isOn(); }
		

	//-- Métodos privados para la inicialización y encendido y apagado de
	//   los componentes cada vez que se enciende o apaga el patinete
	
	private void turnOn()
	{
		elapsedTime = 0;
		distance = 0;
		motor.turnOn();
	}
	
	private void turnOff()
	{
		light.turnOff();
		motor.turnOff();
	}
	

	//-- Métodos para depuración
	//--------------------------
	
	// Si está activada la constante DEBUG muestra por consola un mensaje cada
	// vez que se pasa de un modo a otro; sirve sólo para depuración
	private void modeChanged(Mode mode)
	{
		switch (mode) {
		case CHARGING: debug("Patinete cargando"); break;
		case OFF: debug("Patinete apagado"); break;
		case LOW_BATTERY: debug("Se cambió al modo de batería baja"); break;
		case DRIVE: debug("Se cambió al modo de conducción normal (D)"); break;
		}		
	}
	
	private void debug(String message)
	{
		if (!DEBUG)
			return;
		System.out.printf("  >> %s%n", message);
	}
	
	@Override
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		result.append(String.format("Patinete en modo %s%n", mode));
		result.append(light + System.lineSeparator());
		result.append(motor + System.lineSeparator());
		result.append(battery);
		return result.toString();
	}
}
