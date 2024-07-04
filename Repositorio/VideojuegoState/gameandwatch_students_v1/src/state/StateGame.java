package state;

public interface StateGame {
	
	public void upPressed();
	public void downPressed();
	public void leftPressed();
	public void rightPressed();
	public void backPressed();
	void draw();
	void restart();

}
