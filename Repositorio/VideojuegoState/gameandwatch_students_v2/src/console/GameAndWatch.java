package console;

import state.EstadoJuego;
import state.EstadoMenu;

public class GameAndWatch {

	EstadoJuego estado;

	// # ------------------------------------------------------------------

	public GameAndWatch() {

		this.estado = new EstadoMenu(this);
	}

	// # ------------------------------------------------------------------
	// # Botones de la consola

	public void upPressed() {

		estado.upPressed();
	}

	public void downPressed() {

		estado.downPressed();
	}

	public void leftPressed() {
		estado.leftPressed();
	}

	public void rightPressed() {

		estado.rightPressed();
	}

	public void backPressed() {

		estado.backPressed();
	}

	// # ------------------------------------------------------------------
	// # Otros métodos de la consola

	public boolean exit() {
		return estado.exit();
	}

	public void draw() {

		estado.draw();
	}

	public void gameFinished() {
		draw(); // Necesario para dibujar el último frame
		setEstado(new EstadoMenu(this));
	}

	public void setEstado(EstadoJuego estado) {
		this.estado = estado;
		restart();
	}

	void restart() {
		estado.restart();
	}

}
