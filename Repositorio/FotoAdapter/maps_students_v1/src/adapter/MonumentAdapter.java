package adapter;
import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Monument;

public class MonumentAdapter implements MapElement {

	Monument m;
	GPS gps;
	
	public MonumentAdapter(Monument m) {
		this.m = m;
		this.gps = new GPS();
	}
	
	@Override
	public String getTitle() {
		return "Monumento: " + m.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(m.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return m.toString();
	}

	@Override
	public void open() {
		gps.getDirectionsTo(m.getAddress());

	}

}
