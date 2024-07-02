package model;

public class CDAdapter implements Articulo {
	CompactDisc cd;

	public CDAdapter(CompactDisc c) {
		this.cd = c;
	}

	@Override
	public String getCadena1() {
		// TODO Auto-generated method stub
		return cd.getTitle();
	}

	@Override
	public String getCadena2() {
		// TODO Auto-generated method stub
		return cd.getArtist();
	}

}
