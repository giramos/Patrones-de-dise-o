package model.adapter;

import model.Articulo;
import model.Mobile;

public class AdapterMobile2 implements Articulo {

	Mobile movil;
	
	public AdapterMobile2(Mobile m) {
		this.movil = m;
	}
	@Override
	public String etiquetaUno() {
		// TODO Auto-generated method stub
		return movil.getModel();
	}

	@Override
	public String etiquetaDos() {
		// TODO Auto-generated method stub
		return movil.getBrand();
	}

}
