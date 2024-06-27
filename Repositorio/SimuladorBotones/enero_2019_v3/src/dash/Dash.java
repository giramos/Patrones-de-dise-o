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
        action.accion();
    }

    @Override
    public String toString() 
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("-----------------------\n");
        buffer.append("Dash. Botones actuales:\n");
        for (int button = 0; button < buttonsCount(); button++) {
            Action action = actions[button];
            buffer.append(button + ": " + action.descripcion() + '\n');
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
