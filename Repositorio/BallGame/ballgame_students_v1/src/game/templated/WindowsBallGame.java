package game.templated;

import java.awt.Point;

import platform.Image2D;
import platform.windows.WindowsAPI;

public class WindowsBallGame extends AbstractBallGame {

	WindowsAPI windows;
	
	public WindowsBallGame() {
		this.windows = new WindowsAPI();
	}
	@Override
	public Image2D loadImage(String file) {
		Image2D image;
			image = windows.loadFile(file);
			return image;
	}

	@Override
	public Point getPosition() {
		Point point;
			point = windows.getMouseClick();
			return point;
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		windows.paint(point.x, point.y, image);

	}

}
