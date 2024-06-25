
public class Temperatura {

	double temp;

	public Temperatura(double valor) {
		this.temp = valor;
	}

	public void cambiarAFahrenheit(double tem) {
		this.temp = tem * 9 / 5 + 32;
	}

	public double darCelsius() {
		return temp;
	}

	public double darGradosFahrenheit() {
		return this.temp * 9 / 5 + 32;
	}

	public void cambiarACelsius(double tem) {
		this.temp = tem;
	}
}
