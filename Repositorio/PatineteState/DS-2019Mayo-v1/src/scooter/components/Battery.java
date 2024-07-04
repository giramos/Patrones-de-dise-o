package scooter.components;

public class Battery 
{	
	// capacidad máxima de la batería, en vatios-hora (Wh)
	private static final double MAX_CAPACITY = 474;
	
	private double charge;    // carga actual de la batería, en vatios-hora (Wh)
	
	public Battery()
	{
		this(100);
	}
	
	public Battery(double percentage)
	{
		if (percentage < 0 || percentage > 100)
			throw new IllegalArgumentException("El porcentaje de carga inicial de la batería debe estar entre 0 y 100");
		this.charge = MAX_CAPACITY * percentage / 100;
	}
	
	// Devuelve el nivel de carga actual de la batería expresado como un porcentaje
	public double getLevel()
	{
		return (charge / MAX_CAPACITY) * 100;
	}
	
	//-- Métodos auxiliares para averiguar de manera cómoda si el nivel de carga
	//   de la batería está en alguno de ciertos estados especiales (vacía, baja,
	//   llena...). Son especialmente útiles para evitar posibles errores de precisión
	//   que los clientes de la clase podrían tener al comparar directamente valores
	//   reales.
	
	public boolean isEmpty()
	{
		return Math.abs(getLevel()) <= 0.1;
	}
	
	public boolean isLow()
	{
		return getLevel() < 20;
	}
	
	public boolean isFull()
	{
		return Math.abs(getLevel() - 100) <= 0.000001;
	}

	// Simula la acción de recargar la batería enchufando el patinete a la red eléctrica.
	// Actualiza la carga de la batería añadiendo al nivel que tuviera la nueva carga,
	// expresada como un porcentaje de la capacidad máxima (garantizando que nunca se
	// excederá de dicha capacidad máxima).
	public void charge(double percentage) 
	{
		if (percentage < 0 || percentage > 100)
			throw new IllegalArgumentException("El porcentaje de carga de la batería debe estar entre 0 y 100");
		charge = charge + MAX_CAPACITY * percentage / 100;
		if (charge > MAX_CAPACITY)
			charge = MAX_CAPACITY;
	}
	
	// Simula el consumo de batería consumido por el motor en función de la velocidad.
	// Si la batería está agotada o si se intentan consumir más vatios de los disponibles
	// se lanza un excepción y no se consume nada.
	public void consume(double watts)
	{
		if (isEmpty())
			throw new BatteryLevelException("No se puede consumir energía con la batería agotada");
		if (charge - watts < 0)
			throw new BatteryLevelException(
					String.format("La carga actual (%.2f W) no permite consumir esa cantidad: %.2f W", charge, watts));
		charge = charge - watts;
		assert charge >= 0 : "La batería nunca puede quedar con un valor de carga negativo";
	}
		
	
	//-- Otros métodos
	
	// A los clientes de la clase sólo les interesa el nivel de carga de la batería
	// en forma de porcentaje (método getLevel()) o, en todo caso, saber el estado
	// de la batería (si está vacía, llena, se ha alcanzado el estado de batería baja,
	// etcétera. Esté método, que proporciona información acerca de la carga de la
	// batería a bajo nivel, en vatios, se proporciona únicamente para pruebas unitarias,
	// información de depuración, etcétera.
	//
	double getCharge()
	{
		return charge;
	}
		
	@Override
	public String toString()
	{
		return String.format("Batería de %.0f Wh - Carga actual: %.2f Wh (%d %%)",
				MAX_CAPACITY, getCharge(), getLevel());
	}
}
