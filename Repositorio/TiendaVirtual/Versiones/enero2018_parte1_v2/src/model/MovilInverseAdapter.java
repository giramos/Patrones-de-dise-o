package model;

public class MovilInverseAdapter implements Articulo {
	Mobile movil;

	public MovilInverseAdapter(Mobile m) {
		this.movil = m;
	}

	@Override
	public String getCadena1() {
		// TODO Auto-generated method stub
		return movil.getModel();
	}

	@Override
	public String getCadena2() {
		// TODO Auto-generated method stub
		return movil.getBrand();
	}

}
