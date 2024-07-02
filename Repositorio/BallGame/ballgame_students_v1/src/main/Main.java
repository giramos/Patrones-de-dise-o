package main;

import game.BallGame;
import game.templated.WindowsBallGame;

public class Main {
	public static void main(String[] args) {
		BallGame game = new WindowsBallGame();
		game.play();
	}
}
