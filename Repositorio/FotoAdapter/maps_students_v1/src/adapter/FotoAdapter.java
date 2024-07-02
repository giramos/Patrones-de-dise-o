package adapter;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Photo;

public class FotoAdapter implements MapElement {

	Photo f;
	GPS gps;
	
	public FotoAdapter(Photo f) {
		this.f = f;
		this.gps = new GPS();
	}
	
	@Override
	public String getTitle() {
		return "Foto: " + f.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return gps.getCoordinates(f.getDescription());
	}

	@Override
	public String getHTMLInfo() {
		return f.toString();
	}

	@Override
	public void open() {
		f.show();

	}

}
