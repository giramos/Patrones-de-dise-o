package scooter.components;

public class BatteryLevelException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public BatteryLevelException(String message)
	{
		super(message);
	}
}
