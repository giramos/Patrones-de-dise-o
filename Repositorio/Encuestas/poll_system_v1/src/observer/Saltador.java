package observer;

import poll.Poll;

public class Saltador implements PollObserver {

	private PollObserver po;
	private int numero;
	public Saltador(PollObserver po, int numero) {
		this.po = po;
		this.numero = numero;
	}
	@Override
	public void update(Poll poll) {
		if((poll.getVotosTotales() + 2)% numero == 0)
			po.update(poll);

	}

}
