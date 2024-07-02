package main;

import game.BallGame;
import game.adapter.AdapterWindows;

public class Main {
	public static void main(String[] args) {
		BallGame game = new AdapterWindows();
		game.play();
	}
}
