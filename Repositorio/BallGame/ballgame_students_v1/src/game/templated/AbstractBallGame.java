package game.templated;

import java.awt.Point;

import game.BallGame;
import platform.Image2D;

public abstract class AbstractBallGame implements BallGame {

	public AbstractBallGame() {
		super();
	}

	@Override
	public void play() {

		Image2D image = loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			drawBall(image, point);
		}

	}

	protected abstract Image2D loadImage(String file);

	protected abstract Point getPosition();

	protected abstract void drawBall(Image2D image, Point point);

}