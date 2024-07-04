package observer;

import poll.Poll;

public class SaveResults implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Guardando los resultados...");

	}

}
