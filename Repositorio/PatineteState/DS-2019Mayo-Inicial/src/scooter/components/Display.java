package scooter.components;

/*
 *  La pantalla es realmente una serie de paneles LED y diodos que al encenderse
 *  iluminan varios indicadores de estado grabados en ella. Esta clase es el
 *  controlador que simula lo que sería la actuación sobre los circuitos de la
 *  pantalla mostrando información en dichos paneles y encendiendo y apagando
 *  luces según se le indique a través de sus métodos públicos.
 *  
 *  Concretamente, la pantalla cuenta con:
 *  
 *  - Dos dígitos grandes donde se mostrará la velocidad del patinete
 *  - Debajo de ellos, otros dos paneles para la distancia y el tiempo transcurrido
 *  - Un panel inferior pensado para mostrar el identificador del modo de conducción
 *    actual (por ejemplo, "LOW", "ECO", "D"...)
 *  - Un indicador acerca del estado de las luces del patinete (si están
 *    encendidas o apagadas)
 *  - Varias luces que dibujan una batería y representan su nivel de carga
 *  
 *  El patinete actuará sobre los distintos elementos que conforman la pantalla
 *  llamando a los métodos públicos de esta clase y diciéndole que debe mostrar
 *  en cada uno.
 */
public class Display 
{
	/*
	 * En realidad la pantalla no tiene capacidad de mostrar mensajes personalizados
	 * más allá de lo que se pueda representar en alguno de los paneles LED y diodos
	 * con los que cuenta. En la práctica esto lo haría ya sea mostrando códigos de
	 * error en alguno de esos paneles o con alguna combinación de parpadeo y colores
	 * de las distintas luces. Pero, para nosotros, es suficiente simularlo mostrando
	 * directamente el mensaje de advertencia recibido, tal cual, en la consola.
	 */
	public void alert(String message)
	{
		System.out.println(message);
	}
	
	/*
	 * Cuando está cargando las luces del estado de carga de la batería parpadean
	 * según el nivel indicado. Si la batería está completa se muestran en otro
	 * color y sin parpadear.
	 */
	public void charging(double batteryLevel)
	{
		if (batteryLevel < 100)
			System.out.printf("Cargando... %.0f %%%n", batteryLevel);
		else
			System.out.println("Carga completada");
	}
	
	/*
	 * Actualiza la información mostrada en la pantalla con los valores a mostrar
	 * en los distintos paneles e indicadores.
	 */
	public void show(int speed, double distance, int elapsedTime, 
			String drivingMode, boolean lightOn, double batteryLevel)
	{
		System.out.println("___________________________________");
		System.out.printf("Velocidad: %d km/h%n", speed);
		System.out.printf("Distancia: %.0f metros%n", distance);
		System.out.printf("Tiempo transcurrido: %,d minutos%n", elapsedTime);
		// modo de conducción, si se indicó alguno
		if (!drivingMode.isEmpty()) {
			System.out.printf("Modo de conducción: %s%n", drivingMode);
		}
		// estado de las luces
		if (lightOn)
			System.out.println("Luces encendidas");
		else
			System.out.println("Luces apagadas");
		System.out.printf("Nivel de carga de la batería: %.0f %%%n", batteryLevel);
		System.out.println("___________________________________\n\n");
		
	}
}
