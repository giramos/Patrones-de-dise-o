package scooter;

import scooter.components.*;
import scooter.state.*;
import java.util.*;

public class Scooter 
{	
	private static final boolean DEBUG = true;
	
	public static enum Mode { CHARGING, OFF, LOW_BATTERY, DRIVE }
	
	//-- Los componentes internos del patinete
	public  Display display = new Display();
	public Battery battery = new Battery();
	public Motor motor = new Motor(battery);
	public  Light light = new Light();

	// El tiempo transcurrido y la distancia recorrida desde que se puso en
	// marcha (es decir, desde la última vez que se encendió)
	public int elapsedTime;	// en minutos
	public double distance;	// en metros
	
	HashMap<Mode, EstadoModo> mapa;
	
	private EstadoModo mode;
	
	public Scooter() {
		mapa = new HashMap<>();
		mapa.put(Mode.CHARGING, new EstadoModoCharging(this));
		mapa.put(Mode.OFF, new EstadoModoOff(this));
		mapa.put(Mode.LOW_BATTERY, new EstadoModoLowBattery(this));
		mapa.put(Mode.DRIVE, new EstadoModoDrive(this));
		setMode(Mode.OFF);
	}
	
	
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
		
	public void setMode(Mode off)
	{
		// sólo para depuración, no tiene utilidad práctica
		modeChanged(off); 
		
		this.mode = mapa.get(off);
		
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
		mode.advanceOneMinute();
	}
	
	// Si la batería se agota mientras el patinete está en marcha, éste se apaga.
	// Por otro lado, si baja de un determinado nivel (según el método isLow de
	// la clase Battery) pasa automáticamente al modo de funcionamiento de batería
	// baja (LOW_BATTERY, con una velocidad máxima reducida).
	//
	private void checkBatteryLevel()
	{
		mode.checkBatteryLevel();
	}
	

	//-- Eventos asociados a las distintas pulsaciones del botón de encendido
	//   (pulsación normal, larga o doble, respectivamente)
	
	public void pressPowerButton()
	{
		mode.pressPowerButton();
	}
	
	public void longPressPowerButton()
	{
		mode.longPressPowerButton();
	}
	
	public void doublePressPowerButton() 
	{
		// Ahora mismo no hace nada
		mode.doublePressPowerButton();
	}	

	
	//-- Indica que se ha girado el acelerador y cuánto (expresado como el
	//   porcentaje de giro, que debe ser por tanto un número entre 0 y 100,
	//   donde cero detiene el patinete y cien lo pone a su velocidad máxima
	//   actual, dependiendo del modo de conducción actual y del nivel de
	//   carga de la batería).
	
	public void turnAccelerator(int amount)
	{
		// Sólo tiene efecto cuando el patinete está en marcha
		mode.turnAccelerator(amount);
	}
	
	
	//-- Enchufar y desenchufar el patinete a la red eléctrica para cargarlo	
	
	public void plugPowerAdapter()
	{
		mode.plugPowerAdapter();
	}
	
	public void unplugPowerAdapter()
	{
		mode.unplugPowerAdapter();
	}
	
	
	//-- Actualiza la información mostrada en la pantalla, dependiendo del modo
	public void showDisplay()
	{
		mode.showDisplay();
	}

	
	//-- Métodos públicos de acceso al estado interno del patinete
	//------------------------------------------------------------

	public int getSpeed()					{ return motor.getSpeed(); }
	public double getDistance()				{ return distance; }
	public int getElapsedTime()				{ return elapsedTime; }		
	public double getBatteryLevel()			{ return battery.getLevel(); }
	public boolean isLightOn()				{ return light.isOn(); }
	

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
