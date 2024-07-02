package game.adapter;

import java.awt.Point;

import platform.Image2D;
import platform.android.AndroidAPI;

public class AdapterAndroid implements Plataforma {

	private AndroidAPI api;

	public AdapterAndroid() {
		this.api = new AndroidAPI();
	}

	@Override
	public Image2D loadImage(String file) {
		return api.loadResource(file);
	}

	@Override
	public Point getPosition() {
		return api.getTouch();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		api.draw(point.x, point.y, image);

	}

}
