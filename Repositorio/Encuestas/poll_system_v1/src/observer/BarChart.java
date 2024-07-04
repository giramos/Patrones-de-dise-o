package observer;

import poll.Poll;

public class BarChart implements PollObserver {

	@Override
	public void update(Poll poll) {
		System.out.println("Dibujando un gráfico de barras...");

	}

}
