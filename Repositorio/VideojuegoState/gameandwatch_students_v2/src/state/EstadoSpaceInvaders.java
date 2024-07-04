package state;

import java.util.ArrayList;
import java.util.List;

import console.GameAndWatch;

public class EstadoSpaceInvaders implements EstadoJuego {
	
	private int shipX;

    enum EnemyCell {
        EMPTY, ENEMY
    }

    private List<EnemyCell> enemiesMap;

    private List<Integer> barriersMap;
    private char[] barriersType = new char[] { ' ', '▒', '▓', '█' };

	
	private GameAndWatch game;

	private boolean exit;

	public EstadoSpaceInvaders(GameAndWatch game) {
		this.game = game;
		
	}

	@Override
	public void upPressed() {
		fire();

	}

	@Override
	public void downPressed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void leftPressed() {
		if (shipX > 0)
            shipX--;

	}

	@Override
	public void rightPressed() {
		if (shipX < enemiesMap.size() - 1)
            shipX++;

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
		drawSpaceInvaders();

	}

	@Override
	public void restart() {
		System.out.println("----------------------------");
        System.out.println("Space Invaders!!!");
        System.out.println("(W -> shoot. A/D -> left/right)");
        System.out.println("(C -> menu)");

        initializeSpaceInvaders();

	}

	private void initializeSpaceInvaders() {
        enemiesMap = new ArrayList<>(List.of(
                EnemyCell.EMPTY,
                EnemyCell.EMPTY,
                EnemyCell.ENEMY,
                EnemyCell.EMPTY,
                EnemyCell.ENEMY,
                EnemyCell.EMPTY,
                EnemyCell.ENEMY,
                EnemyCell.EMPTY,
                EnemyCell.EMPTY));

        barriersMap = new ArrayList<>();
        for (var content : enemiesMap)
            barriersMap.add(content == EnemyCell.ENEMY ? barriersType.length - 1 : 0);

        shipX = 4;
    }

	@Override
	public String toString() {
		return "Space Invaders";
	}
	
    private void fire() {

        if (barriersMap.get(shipX) > 0) {
            barriersMap.set(shipX, barriersMap.get(shipX) - 1);
            return;
        }

        if (enemiesMap.get(shipX) == EnemyCell.ENEMY) {
            enemiesMap.set(shipX, EnemyCell.EMPTY);

            if (enemiesMap.stream().noneMatch(content -> content == EnemyCell.ENEMY)) {
                game.gameFinished();
                System.out.println("Congratulations! You won!");
            }
        }
    }

    public void drawSpaceInvaders() {
        System.out.println();

        var screenSize = enemiesMap.size();

        System.out.println("┌" + "─".repeat(screenSize) + "┐");

        // draw enemies
        System.out.print("│");
        for (var content : enemiesMap)
            System.out.print(content == EnemyCell.EMPTY ? ' ' : '¥');
        System.out.println("│");

        drawBlanLine(screenSize);

        // draw barriers
        System.out.print("│");
        for (var content1 : barriersMap)
            System.out.print(barriersType[content1]);
        System.out.println("│");
        drawBlanLine(screenSize);

        // draw ship
        System.out.println("│" + " ".repeat(shipX) + '^' + " ".repeat(screenSize - shipX - 1) + "│");

        System.out.println("└" + "─".repeat(screenSize) + "┘");
    }

    private void drawBlanLine(int screenSize) {
        System.out.println("│" + " ".repeat(screenSize) + "│");
    }
}
