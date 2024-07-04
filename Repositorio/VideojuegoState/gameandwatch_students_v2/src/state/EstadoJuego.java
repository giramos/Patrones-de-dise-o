package state;

public interface EstadoJuego {

	void upPressed();
	void downPressed();
	void leftPressed();
	void rightPressed();
	void backPressed();
	boolean exit();
	void draw();
	void restart();
}
