package state;

import java.util.List;

import console.GameAndWatch;

public class EstadoMenu implements EstadoJuego {
	
	private List<EstadoJuego> games;
    private int selectedGame;
    private GameAndWatch game;
	private boolean exit;
    
    public EstadoMenu(GameAndWatch game) {
    	this.game = game;
    	this.games = List.of(new EstadoMortalMaze(game), new EstadoF1(game), new EstadoSpaceInvaders(game));
        selectedGame = 0;
    }

    @Override
	public String toString() {
		return "Menú";
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
		game.setEstado(games.get(selectedGame));

	}

	@Override
	public void backPressed() {
		exit = true;

	}

	@Override
	public boolean exit() {
		// TODO Auto-generated method stub
		return exit;
	}

	@Override
	public void draw() {
		System.out.println("\n--------------------");
        System.out.println("Select a game: (W/S -> up/down. D -> play game)");
        for (int i = 0; i < games.size(); i++) {
            System.out.print((i == selectedGame) ? " >> " : "    ");
            System.out.println(games.get(i));
        }
        System.out.println("(C -> turn off)");

	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub

	}

}
