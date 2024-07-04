package scooter.simulator;

import java.io.*;

import scooter.Scooter;

public class Simulator 
{
	private Scooter scooter;
	private BufferedReader input;
	private PrintStream output = System.out;
	private boolean interactive;
	private boolean exit;
	
	public Simulator(Scooter scooter)
	{
		this.scooter = scooter;
		input = new BufferedReader(new InputStreamReader(System.in));
		interactive = true;
	}
	
	// En vez de ejecutar el menú en modo interactivo esta versión lee las
	// acciones a ejecutar del fichero de entrada especificado.
	public Simulator(Scooter scooter, String filename) throws FileNotFoundException
	{
		this.scooter = scooter;
		input = new BufferedReader(new FileReader(filename));
	}
	
	public void run()
	{
		showHelp();
		while (!exit) {
			try {
				menu(askUser());
			} catch (Exception e) {
				output.println(e.getMessage());
			}
		}
		output.println("¡Adios!");
	}		
	
	//-- Menú principal
		
	// En el parámetro userInput este método recibe un array de cadenas de uno o
	// dos elementos dependiendo de si la opción introducida previamente por el
	// usuario en el método askUser tenía o no parámetros:
	//
	// 		userInput[0] => nombre de la opción escogida
	// 		userInput[1] (opcional) => parámetros, si los hubiera
	//
	// Por ejemplo, para las siguientes entradas de usuario, este método recibiría:
	//
	//		"acelerar 80" 	=> 	["acelerar", "80"]
	//		"pulsar_doble" 	=> 	["pulsar_doble"]
	//		
	private void menu(String[] userInput) throws UserInputException
	{		
		String option = userInput[0];
		if (option.equals("salir")) {
			exit = true;
		} else if (option.equals("ayuda")) {
			showHelp();
		} else if (option.equals("mostrar")) {
			scooter.showDisplay();
		} else if (option.equals("acelerar")) {
			checkHasArgument(userInput, "Se debe indicar cuánto se ha girado el acelerador (0-100)");
			int percentage = asNumber(userInput[1]);
			if (percentage < 0 || percentage > 100)
				throw new UserInputException("El porcentaje de giro del acelerador debe ser un número entre 0 y 100");
			scooter.turnAccelerator(percentage);
		} else if (option.equals("pulsar")) {
			scooter.pressPowerButton();
		} else if (option.equals("pulsar_largo")) {
			scooter.longPressPowerButton();				
		} else if (option.equals("pulsar_doble")) {
			scooter.doublePressPowerButton();				
		} else if (option.equals("enchufar")) {
			scooter.plugPowerAdapter();
		} else if (option.equals("desenchufar")) {
			scooter.unplugPowerAdapter();
		} else if (option.equals("avanzar")) {
			checkHasArgument(userInput, "Se debe indicar el tiempo transcurrido (en minutos)");
			int elapsedTime = asNumber(userInput[1]);
			if (elapsedTime < 0)
				throw new UserInputException("¡El tiempo transcurrido no puede ser negativo!");
			scooter.simulateAdvanceTime(elapsedTime);
		}
	}
	
	// Comprueba que la opción introducida por el usuario tenga un parámetro.
	private void checkHasArgument(String userInput[], String message) throws UserInputException
	{
		if (userInput.length != 2)
			throw new UserInputException(message);
	}

	// Convierte un parámetro introducido por el usuario de texto a número.
	private int asNumber(String value) throws UserInputException
	{
		try {
			int result = Integer.valueOf(value);
			return result;
		} catch (NumberFormatException e) {
			throw new UserInputException("Parámetro incorrecto, se esperaba un número: " + value);
		}	
	}

	/*
	 * Lee una línea (ya sea por pantalla o del fichero de entrada especificado en el
	 * constructor, en su caso) que contiene la entrada de usuario y devuelve un array
	 * de cadenas de texto de al menos un elemento y como máximo dos, donde el primer
	 * elemento es el nombre de la opción elegida y el segundo, de haberlo, contiene
	 * sus parámetros. Por ejemplo:
	 * 
	 *		"acelerar 80" => ["acelerar", "80"]
	 *		"pulsar_doble" => ["pulsar_doble"]
	 *		"" => [""]
	 *		"  esto     es   una prueba" => ["esto", "    es   una prueba"]
	 */
	private String[] askUser()
	{
		output.print("> ");
		output.flush();
		try {
			String userInput = input.readLine();			
			// si no está en modo interactivo, sino leyendo la entrada de usuario de un
			// fichero y escribiendo la salida en otro, escribe la supuesta entrada de
			// usuario (lo que se acaba de leer del fichero de entrada) en la salida
			if (!interactive) {
				output.println(userInput);
			}
			return userInput.trim().toLowerCase().split("[ ]", 2);			
		} catch (IOException e) {
			System.out.println("No se pudo leer la entrada del usuario: el programa debe finalizar");
			System.exit(1);
			throw new AssertionError("No debería estar aquí, el programa ya ha finalizado");
		}
	}
	
	
	//-- Métodos privados correspondientes a las acciones del menú
	//--------------------------------------------------------------------------------------------
	
	private void showHelp()
	{
		output.println("Manejo: acelerar <porcentaje> - pulsar - pulsar_largo - pulsar_doble");
		output.println("Carga: enchufar - desenchufar");
		output.println("Otras acciones: avanzar <minutos> - mostrar - salir - ayuda");
		output.println("--------------------------------------------------------------------");
	}	
}
