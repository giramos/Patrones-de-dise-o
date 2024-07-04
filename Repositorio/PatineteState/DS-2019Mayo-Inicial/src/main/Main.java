package main;

import java.io.FileNotFoundException;

import scooter.Scooter;
import scooter.simulator.Simulator;

public class Main {
	private Scooter scooter = new Scooter();
	private Simulator simulator = new Simulator(scooter);

	public static void main(String[] args) throws FileNotFoundException {
		new Main().run();
	}

	public void run() throws FileNotFoundException {
		simulator = new Simulator(scooter, "interaction_sample_1.txt");
		simulator.run();
	}
}
