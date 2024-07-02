package adapter;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Restaurant;

public class RestaurantAdapter implements MapElement {

	Restaurant r;
	GPS gps;
	
	public RestaurantAdapter(Restaurant r) {
		this.r = r;
		this.gps = new GPS();
	}
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "Restaurante: " + r.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(r.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		// TODO Auto-generated method stub
		return r.toString();
	}

	@Override
	public void open() {
		r.call();

	}

}
