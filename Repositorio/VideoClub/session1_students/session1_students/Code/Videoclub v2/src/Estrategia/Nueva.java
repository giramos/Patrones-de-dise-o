package Estrategia;

public class Nueva implements TipoMovie {

	double thisAmount; 
	int puntos; 
	
	@Override
	public double getPrecioAlquiler(int days) {
		return (thisAmount += days * 3);
	}

	@Override
	public int getPuntosAlquiler(int days) {
		puntos = 1;
		if(days > 1) {
			puntos++;
		}
		return puntos;
	}

}
