package state;

import java.util.List;

public class StateGameMenu implements StateGame {
	
	StateGameMenu screen;
    boolean exit;

    //# ------------------------------------------------------------------
    //# Variables del Menu

    private List<StateGame> games;
    private int selectedGame;
	
	public StateGameMenu() {
		//$ Inicialización del menu -----------------------------
        this.games = List.of(new StateGameMortalMaze(), new StateGameF1(), new StateGameSpaceInvaders());
        selectedGame = 0;

//        this.screen = new StateGameMenu();
	}

	@Override
	public void upPressed() {
		if (selectedGame > 0)
            selectedGame--;

	}

	@Override
	public void downPressed() {
		if (selectedGame < games.size() - 1)
            selectedGame++;

	}

	@Override
	public void leftPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightPressed() {
		games.get(selectedGame);
	}


	@Override
	public void backPressed() {
		exit = true;

	}

	@Override
	public void draw() {
		drawMenu();

	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub

	}

	 public void drawMenu() {
	        System.out.println("\n--------------------");
	        System.out.println("Select a game: (W/S -> up/down. D -> play game)");
	        for (int i = 0; i < games.size(); i++) {
	            System.out.print((i == selectedGame) ? " >> " : "    ");
	            System.out.println(games.get(i));
	        }
	        System.out.println("(C -> turn off)");
	    }
}
