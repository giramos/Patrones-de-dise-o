package model.adapter;

import model.Articulo;
import model.CompactDisc;

public class AdapterCompactDisc implements Articulo {

	CompactDisc cd;

	public AdapterCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public String etiquetaUno() {
		// TODO Auto-generated method stub
		return cd.getTitle();
	}

	@Override
	public String etiquetaDos() {
		// TODO Auto-generated method stub
		return cd.getArtist();
	}

}
