package model;

public class MovilAdapter implements Articulo {
	Mobile movil;

	public MovilAdapter(Mobile m) {
		this.movil = m;
	}

	@Override
	public String getCadena1() {
		// TODO Auto-generated method stub
		return movil.getBrand();
	}

	@Override
	public String getCadena2() {
		// TODO Auto-generated method stub
		return movil.getModel();
	}

}
