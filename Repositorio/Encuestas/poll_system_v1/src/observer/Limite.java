package observer;

import poll.Poll;

public class Limite implements PollObserver {

	PollObserver po;
	private int limite;

	public Limite(PollObserver po, int limite) {
		this.po = po;
		this.limite = limite;
	}

	@Override
	public void update(Poll poll) {
		if (poll.getVotosTotales() > limite)
			po.update(poll);

	}

}
