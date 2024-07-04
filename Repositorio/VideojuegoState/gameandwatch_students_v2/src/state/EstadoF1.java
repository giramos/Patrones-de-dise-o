package state;

import java.util.List;

import console.GameAndWatch;

public class EstadoF1 implements EstadoJuego {
	
	private static final char GOAL = 'X';
    private static final char PATH = '*';
    private static final int ROAD_WIDTH = 6;

    private static final int ROWS_ABOVE = 6;
    private static final int ROWS_BELOW = 2;

    private int carX, carY;

    private List<String> road ;
	private GameAndWatch game;
	private boolean exit;
    
    public EstadoF1(GameAndWatch game) {
    	this.game = game;
    	this.road  = List.of(
                "  " + GOAL,
                "  " + PATH,
                "    " + PATH,
                "     " + PATH,
                "      " + PATH,
                "      " + PATH,
                "      " + PATH,
                "    " + PATH,
                "  " + PATH,
                " " + PATH,
                " " + PATH);
    }

	@Override
	public void upPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftPressed() {
		carX--;
        carY--; // Avanzar
        checkCarPosition();

	}

	@Override
	public void rightPressed() {
		carX++;
        carY--; // Avanzar
        checkCarPosition();

	}

	@Override
	public void backPressed() {
		game.setEstado(new EstadoMenu(game));

	}

	@Override
	public boolean exit() {
		return exit;
	}

	@Override
	public void draw() {
		for (int row = carY - ROWS_ABOVE; row <= carY + ROWS_BELOW; row++)
			drawRow(row);

	}

	@Override
	public void restart() {
		System.out.println("----------------------------");
		System.out.println("F1 Grand Prix!!!");
		System.out.println("(A/D -> left/right)");
		System.out.println("(C -> menu)");

		initializeF1();

	}

	private void drawRow(int row) {

		if (row < 0 || row >= road.size()) {
			System.out.println();
			return;
		}

		var line = new StringBuilder();

		if (row == 0)
			line.append(" ########");

		else {
			int padding = road.get(row).indexOf(PATH);
			line.append(" ".repeat(padding));

			char border = '|';
			if (row < road.size() - 1) {
				var rowBelow = road.get(row + 1);
				int paddingBelow = rowBelow.indexOf(PATH);
				if (paddingBelow > padding)
					border = '\\';
				else if (paddingBelow < padding)
					border = '/';
			}

			line.append(border);
			line.append(" ".repeat(ROAD_WIDTH));
			line.append(border);
		}

		if (carY == row)
			line.setCharAt(carX, '█');

		System.out.println(line);
	}
	@Override
	public String toString() {
		return "Formula 1 - Grand Prix";
	}

	private void initializeF1() {
		carX = 5;
		carY = road.size() - 1;
	}

	private void checkCarPosition() {
		if (carY == 0) {
			game.gameFinished();
			System.out.println("Congratulations! You won!");
			return;
		}

		var row = road.get(carY);
		int leftLimit = row.indexOf(PATH);
		int rightLimit = leftLimit + ROAD_WIDTH + 1;

		if (carX <= leftLimit || carX >= rightLimit) {
			System.out.println("You crashed!. Start again");
			initializeF1();
		}
	}
}
