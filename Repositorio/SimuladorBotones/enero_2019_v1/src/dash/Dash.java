package dash;

public class Dash 
{
    public Dash(Accion... actions) 
    {
        this.acciones = actions;
        buttonsCount = actions.length;
    }

    public int buttonsCount() 
    {
        return buttonsCount;
    }

    public void changeButton(int button, Accion action) 
    {
    	checkIsValidButton(button);
        acciones[button] = action;
    }

    public void pressButton(int button) 
    {
    	checkIsValidButton(button);
        Accion accion = acciones[button];
        if (accion == null)
            System.out.println("[Botón sin configurar]");
        else {
            accion.execute();
        }
    }

	

    @Override
    public String toString() 
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("-----------------------\n");
        buffer.append("Dash. Botones actuales:\n");
        for (int button = 0; button < buttonsCount(); button++) {
//            Action action = actions[button];
            Accion action = acciones[button];
            String description = "No hacer nada";

           if(action != null)
        	   description = action.descipcion();
           
            buffer.append(button + ": " + description + '\n');
        }
        return buffer.toString();
    }

    private void checkIsValidButton(int button) 
    {
    	if (button < 0 || button >= buttonsCount)
    		throw new IllegalArgumentException("¡" + button + " no es un número de botón válido!");
    }

    private Accion[] acciones;
    private int buttonsCount;
}
