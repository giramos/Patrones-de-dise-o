package dash;

public class Dash 
{
    public Dash(Action... actions) 
    {
        this.actions = actions;
        buttonsCount = actions.length;
    }

    public int buttonsCount() 
    {
        return buttonsCount;
    }

    public void changeButton(int button, Action action) 
    {
    	checkIsValidButton(button);
        actions[button] = action;
    }

    public void pressButton(int button) 
    {
    	checkIsValidButton(button);
        Action action = actions[button];
        if (action == null)
            System.out.println("[Botón sin configurar]");
        else {
            if (action == Action.ORDER_COFFEE) {
                System.out.println("Conectando con el servidor...");
                System.out.println("Pedido online realizado de café");
            } else if (action == Action.ORDER_GILLETTE) {
                System.out.println("Conectando con el servidor...");
                System.out.println("Pedido online realizado de Gillete");
            } else if (action == Action.TELL_THE_TIME)
                System.out.println("Son las 12:00");
            else
                System.out.println("Acción no reconocida");
        }
    }

    @Override
    public String toString() 
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("-----------------------\n");
        buffer.append("Dash. Botones actuales:\n");
        for (int button = 0; button < buttonsCount(); button++) {
            Action action = actions[button];
            String description = "No hacer nada";

            if (action != null) {
                if (action == Action.ORDER_COFFEE)
                    description = "Pedir online café";
                else if (action == Action.ORDER_GILLETTE)
                    description = "Pedir online Gillette";
                else if (action == Action.TELL_THE_TIME)
                    description = "Decir la hora";
                else
                    description = "Acción no reconocida";
            }
            buffer.append(button + ": " + description + '\n');
        }
        return buffer.toString();
    }

    private void checkIsValidButton(int button) 
    {
    	if (button < 0 || button >= buttonsCount)
    		throw new IllegalArgumentException("¡" + button + " no es un número de botón válido!");
    }

    private Action[] actions;
    private int buttonsCount;
}
