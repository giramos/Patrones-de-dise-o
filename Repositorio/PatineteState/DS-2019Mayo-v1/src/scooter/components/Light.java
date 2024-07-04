package scooter.components;

public class Light 
{
	private boolean isOn;
	
	public void turnOn()
	{
		isOn = true;
	}
	
	public void turnOff()
	{
		isOn = false;
	}
	
	public boolean isOn()
	{
		return isOn;
	}
	
	@Override
	public String toString()
	{
		return isOn ? "Luces encendidas" : "Luces apagadas";
	}
}
