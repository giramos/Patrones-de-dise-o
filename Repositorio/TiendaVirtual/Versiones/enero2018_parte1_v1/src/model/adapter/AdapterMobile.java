package model.adapter;

import model.Articulo;
import model.Mobile;

public class AdapterMobile implements Articulo {

	Mobile movil;
	
	public AdapterMobile(Mobile m) {
		this.movil = m;
	}
	@Override
	public String etiquetaUno() {
		// TODO Auto-generated method stub
		return movil.getBrand();
	}

	@Override
	public String etiquetaDos() {
		// TODO Auto-generated method stub
		return movil.getModel();
	}

}
