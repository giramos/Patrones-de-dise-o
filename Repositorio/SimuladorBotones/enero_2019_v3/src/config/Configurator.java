package config;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import dash.*;

public class Configurator 
{
	List<Action> acciones = new ArrayList<Action>();
	
    public void configure(Dash dash) throws IOException 
    {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("CONFIGURADOR");
        System.out.println(dash);

        try {
            System.out.println("Escriba el número de botón a cambiar:");
            int button = Integer.parseInt(in.readLine());
            if (button < 0 || button >= dash.buttonsCount()) {
                System.out.println("No es un número de botón válido: operación cancelada");
                return;
            }

            System.out.println("Escriba el número de acción a asignar al botón de entre las siguientes (o 'N' para ninguna):");
            printActions();
            System.out.print("> ");
            String line = in.readLine();

            // Comprueba primero si la opción escogida para ese botón es no hacer nada 
            if (line.toUpperCase().equals("N")) {
                dash.changeButton(button, null);
                System.out.println("Botón asignado");
                return;
            }
            
            // Si no, es que tiene que tratarse de una acción existente
            int actionNumber = Integer.parseInt(line);
            if (actionNumber < 0 || actionNumber >= acciones.size()) {
                System.out.println("No es una acción válida: operación cancelada");
                return;
            }
            dash.changeButton(button, acciones.get(actionNumber));
            
            System.out.println("Botón asignado");

        } catch (NumberFormatException e) {
            System.out.println("Se esperaba un número");
        }
    }

    private void printActions() 
    {
    	for(int i=0; i<acciones.size(); i++) {
    		System.out.println(" " + i + "." + acciones.get(i).descripcion());
    	}
    }

    public void añadir(List<Action> action) {
    	for(Action i: acciones)
    		acciones.add(i);
    }
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
}
