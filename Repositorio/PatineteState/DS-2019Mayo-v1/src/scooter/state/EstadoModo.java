package scooter.state;

public interface EstadoModo {

	void showDisplay();
	void turnAccelerator(int amount);
	void pressPowerButton();
	void longPressPowerButton();
	void doublePressPowerButton() ;
	void plugPowerAdapter();
	void unplugPowerAdapter();
	void advanceOneMinute();
	void checkBatteryLevel();
	
}
