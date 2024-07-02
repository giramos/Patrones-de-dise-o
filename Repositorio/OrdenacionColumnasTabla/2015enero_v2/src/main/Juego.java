package main;

public class Juego {
	private int ranking;
	private String nombre;
	private double media;
	private long votos;

	public Juego(int ranking, String nombre, double d, long votos) {
		this.ranking = ranking;
		this.nombre = nombre;
		this.media = d;
		this.votos = votos;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public long getVotos() {
		return votos;
	}

	public void setVotos(long votos) {
		this.votos = votos;
	}

}
