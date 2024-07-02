package game;

import java.awt.Point;

import game.adapter.Plataforma;
import platform.Image2D;

public class BallGameAdapter {

	Plataforma plataforma;
	
	public BallGameAdapter(Plataforma p) {
		this.plataforma = p;
	}
	
	public void play() {
		Image2D image = plataforma.loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = plataforma.getPosition();
			plataforma.drawBall(image, point);
		}
	}
}
