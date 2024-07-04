package scooter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScooterTest 
{
	private static final double DELTA = 0.01;
	
	private Scooter scooter;
	
	@Before
	public void setUp()
	{
		scooter = new Scooter();
	}
	
	@Test
	public void testOff() 
	{
		// si aceleramos sin encender el patinete no hace nada
		scooter.turnAccelerator(100);
		assertEquals(0, scooter.getSpeed());
	}
	
	@Test
	public void testAccelerate()
	{
		scooter.pressPowerButton();
		scooter.turnAccelerator(100);
		assertEquals(25, scooter.getSpeed());
		scooter.simulateAdvanceTime(10);
		assertEquals(25, scooter.getSpeed());
		scooter.turnAccelerator(80);
		assertEquals(20, scooter.getSpeed());
		scooter.turnAccelerator(0);
		assertEquals(0, scooter.getSpeed());
	}
	
	@Test
	public void testLights()
	{
		// encendemos el patinete
		scooter.pressPowerButton();
		// encendemos las luces
		scooter.pressPowerButton();
		assertTrue(scooter.isLightOn());
		// las apagamos
		scooter.pressPowerButton();
		assertFalse(scooter.isLightOn());
		// circulamos durante diez minutos
		scooter.turnAccelerator(90);
		scooter.simulateAdvanceTime(10);
		// volvemos a encender las luces
		scooter.pressPowerButton();
		assertTrue(scooter.isLightOn());
		// si apagamos el patinete las luces deben apagarse también
		// si estaban encendidas
		scooter.turnAccelerator(0);
		scooter.longPressPowerButton(); // para apagar el patinete
		assertFalse(scooter.isLightOn());	
	}
	
	@Test
	public void testDistance()
	{
		// encendemos el patinete y circulamos a 25 km/h durante 12 minutos
		scooter.pressPowerButton();
		scooter.turnAccelerator(100);
		assertEquals(25, scooter.getSpeed());
		scooter.simulateAdvanceTime(12);
		// la distancia recorrida deben ser 5 km
		assertEquals(5000, scooter.getDistance(), DELTA);
		
		// bajamos la velocidad a 20 km/h (el 80 % de 25 km/h)
		scooter.turnAccelerator(80);
		// circulamos otra media hora
		scooter.simulateAdvanceTime(30);
		// en esa media hora ha debido recorrer otros 10 km (15 en total)
		assertEquals(15000, scooter.getDistance(), DELTA);
	}

	@Test
	public void testAutonomy()
	{
		// encendemos el patinete y circulamos a la máxima velocidad
		// hasta agotar la batería
		scooter.pressPowerButton();
		scooter.turnAccelerator(100);
		// (indicamos una cantidad de tiempo enorme)
		scooter.simulateAdvanceTime(999);
		// al final la distancia recorrida deben ser 39,5 km
		
		// (Explicación: si en una hora a máxima potencia consume 300 W,
		//  por cada minuto consume 300 / 60 = 5 W por minuto); así que
		//  en una hora habrá recorrido 25 km y quedarán 474 - 300 = 174
		//  vatios en la batería. Como el 20 % (batería baja) de 474 es
		//  94,8: 174 - 94,8 = 79,2; redondeando: 80 W / 5 W/min = 16
		//  minutos más a máxima velocidad hasta alcanzar el estado de
		//  batería baja. O sea, 76 minutos a máxima velocidad.
		//
		//  En esos 76 minutos a 25 km/h habrá recorrido 31.666,67 metros.
		//
		//  Pasa al modo de batería baja (5 km/h) donde consume una quinta
		//  parte (1 vatio por minuto). Como quedaban 94,8 W recorrería otros
		//  94 minutos antes de agotar la batería, y habría recorrido en
		//  ese tiempo otros 7.833,33 metros. Resumiendo:
		//
		//  1) 76 minutos en modo DRIVE (25 km/h) = 31.666,67 metros
		//  2) Cambia al modo de batería baja al bajar del 20 % de carga
		//  3) 94 minutos en modo LOW_BATTERY (5 km/h) = 7.833,33 metros
		//
		//  Total: 210 minutos y 39.500 metros
		
		assertEquals(170, scooter.getElapsedTime());
		assertEquals(39500, scooter.getDistance(), DELTA);
		
		// Nótese que aunque el patinete esté apagado es posible consultar
		// los datos relativos a la última vez que estuvo en marcha (no
		// se inicializan hasta que no se vuelve a encender el patinete).
	}
}
