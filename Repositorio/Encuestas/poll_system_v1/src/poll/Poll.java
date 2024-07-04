package poll;

import java.util.List;
import java.util.ArrayList;

import observer.PollObserver;

public class Poll {
	private int yeses, nos;
	private String question;
	List<PollObserver> lista;

	public Poll(String question) {
		this.question = question;
		lista = new ArrayList<PollObserver>();
	}

	public String getQuestion() {
		return question;
	}

	public int getYeses() {
		return yeses;
	}

	public int getNos() {
		return nos;
	}

	public void incrementYeses() {
		yeses++;
		notificar();
	}

	public void incrementNos() {
		nos++;
		notificar();
	}

	private void notificar() {
		for (PollObserver i : lista) {
			i.update(this);
		}
	}

	public void añadir(PollObserver ob) {
		lista.add(ob);
	}

	public void borrar(PollObserver ob) {
		lista.remove(ob);
	}

	public int getVotosTotales() {
		return getYeses() + getNos();
	}

}
