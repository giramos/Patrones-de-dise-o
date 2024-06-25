package config;

import java.io.*;

import dash.*;

public class Configurator 
{
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
            if (actionNumber < 0 || actionNumber >= 2) {
                System.out.println("No es una acción válida: operación cancelada");
                return;
            }

            if (actionNumber == 0) {
                dash.changeButton(button, Action.ORDER_COFFEE);
            } else if (actionNumber == 1) {
                dash.changeButton(button, Action.ORDER_GILLETTE);
            } else if (actionNumber == 2)
                dash.changeButton(button, Action.TELL_THE_TIME);

            System.out.println("Botón asignado");

        } catch (NumberFormatException e) {
            System.out.println("Se esperaba un número");
        }
    }

    private void printActions() 
    {
        System.out.println("  N. No hacer nada");
        System.out.println("  0. Pedir online café");
        System.out.println("  1. Pedir online Gillette");
        System.out.println("  2. Decir la hora");
    }

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
}
