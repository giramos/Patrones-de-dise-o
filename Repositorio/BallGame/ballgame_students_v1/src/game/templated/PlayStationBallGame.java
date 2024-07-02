package game.templated;

import java.awt.Point;

import platform.Image2D;
import platform.playstation.Playstation5API;

public class PlayStationBallGame extends AbstractBallGame {

	Playstation5API playstation;

	public PlayStationBallGame() {
		this.playstation = new Playstation5API();
	}

	@Override
	public Image2D loadImage(String file) {
		Image2D image;
		image = playstation.loadGraphics(file);
		return image;
	}

	@Override
	public Point getPosition() {
		Point point;
		point = playstation.getJoystick();
		return point;
	}

	@Override
	public void drawBall(Image2D image, Point point) {

		playstation.render(point.x, point.y, image);

	}

}
