package game.adapter;

import java.awt.Point;

import platform.Image2D;
import platform.android.AndroidAPI;

public class AdapterAndroid extends AbstractAdapter {

	private AndroidAPI android;

	public AdapterAndroid() {
		super();
		this.android = new AndroidAPI();
	}

	@Override
	public Image2D loadImage(String file) {
		Image2D image;
		image = android.loadResource(file);
		return image;
	}

	@Override
	public Point getPosition() {
		Point point;
		point = android.getTouch();
		return point;
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		android.draw(point.x, point.y, image);

	}

}
