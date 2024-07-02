package main;

import game.BallGame;
import game.templated.WindowsBallGame;
import game.BallGameAdapter;
import game.adapter.AdapterAndroid;

public class Main {
	public static void main(String[] args) {
		// Templated
		BallGame game = new WindowsBallGame();
		game.play();
		// Adapter
		BallGameAdapter game2 = new BallGameAdapter(new AdapterAndroid());
		game2.play();
	}
}
