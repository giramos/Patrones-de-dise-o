package scooter.components;

public class Motor 
{
	// Velocidad máxima que es capaz de alcanzar el patinete con el motor a la
	// máxima potencia
	private static final int MAX_SPEED = 25;
	
	// Energía consumida en una hora, en vatios, con el motor a la máxima potencia
	// (o, lo que es lo mismo, con el patinete a la velocidad máxima posible)
	private static final int POWER = 300;
	
	private Battery battery;

	// los distintos modos de conducción pueden modificar la velocidad máxima actual
	private int maximumSpeed = MAX_SPEED;
	// un valor entre 0 y 100 que representa el porcentaje de giro del acelerador
	private int acceleration;
	// velocidad actual, determinada por la velocidad máxima actual y el porcentaje
	// de aceleración
	private int speed;			
	private boolean isOn;

	public Motor(Battery battery)
	{
		this.battery = battery;
	}
	
	//-- Métodos para encender y apagar el motor
	
	public boolean isOn()
	{
		return isOn;
	}
	
	public void turnOn()
	{
		isOn = true;
	}
	
	public void turnOff()
	{
		acceleration = 0;
		speed = 0;
		isOn = false;
	}
	
	
	//-- Métodos que actúan sobre el funcionamiento del motor y que determinan la
	//   velocidad actual del patinete y el consumo de energía de la batería
	//---------------------------------------------------------------------------
	
	public void setMaximumSpeed(int maximumSpeed)
	{
		checkIsOn();
		if (maximumSpeed > MAX_SPEED)
			throw new IllegalArgumentException("La velocidad máxima actual no puede exceder la máxima posible");
		if (maximumSpeed < 0)
			throw new IllegalArgumentException("¡La velocidad máxima actual no puede ser menor que cero!");
		this.maximumSpeed = maximumSpeed;
		updateSpeed();
	}
	
	public void accelerate(int percentage)
	{
		checkIsOn();
		if (percentage < 0 || percentage > 100)
			throw new IllegalArgumentException("¡El porcentaje del acelerador debe estar entre cero y cien!");
		this.acceleration = percentage;
		updateSpeed();
	}
	
	// Llamado cuando se modifican o la velocidad máxima actual o la aceleración:
	// en ambos casos se recalcula la velocidad actual a la que rueda el patinete.
	private void updateSpeed()
	{
		speed = maximumSpeed * acceleration / 100;
		assert speed >= 0 && speed <= maximumSpeed : "La velocidad está siempre entre 0 y la velocidad máxima actual";		
	}
	
	public int getSpeed() 
	{
		return speed;
	}

	// Actualiza el consumo del motor a la velocidad actual para el tiempo
	// transcurrido que se indica (en minutos).
	public void updateComsumption(int elapsedTime)
	{
		checkIsOn();
		// potencia, en vatios, que consumiría en una hora a la velocidad actual
		double power = POWER * speed / MAX_SPEED;
		// vatios consumidos en la duración de tiempo especificada (minutos)
		double watts = power * elapsedTime / 60;
		battery.consume(watts);
	}
	
	
	//-- Otros métodos auxiliares
	
	private void checkIsOn()
	{
		if (!isOn)
			throw new IllegalStateException("¡El motor está apagado!");
	}
	
	@Override
	public String toString()
	{
		return String.format(
				"Motor de %d W - Velocidad actual/máxima actual: [%d km/h]/[%d km/h] (%d %%)",
				POWER, speed, maximumSpeed, acceleration);
	}
}
