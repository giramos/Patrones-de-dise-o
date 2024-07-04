package observer;

import poll.Poll;

public class PieChart implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Dibujando un gráfico circular...");

	}

}
