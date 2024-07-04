package console;

import java.util.*;

public class GameAndWatch {

    String screen;
    boolean exit;

    //# ------------------------------------------------------------------
    //# Variables del Menu

    private List<String> games;
    private int selectedGame;

    //# ------------------------------------------------------------------
    //# Variables de Mortal Maze

    private static final int WIDTH = 14;
    private static final int HEIGHT = 7;

    private int playerX, playerY;
    private int exitX, exitY;

    //# ------------------------------------------------------------------
    //# Variables de F1 Grand Prix

    private static final char GOAL = 'X';
    private static final char PATH = '*';
    private static final int ROAD_WIDTH = 6;

    private static final int ROWS_ABOVE = 6;
    private static final int ROWS_BELOW = 2;

    private int carX, carY;

    private List<String> road = List.of(
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

    //# ------------------------------------------------------------------
    //# Variables de Space Invaders

    private int shipX;

    enum EnemyCell {
        EMPTY, ENEMY
    }

    private List<EnemyCell> enemiesMap;

    private List<Integer> barriersMap;
    private char[] barriersType = new char[] { ' ', '▒', '▓', '█' };

    //# ------------------------------------------------------------------

    public GameAndWatch() {

        //$ Inicialización del menu -----------------------------
        this.games = List.of("Mortal Maze", "F1 Grand Prix", "Space Invaders");
        selectedGame = 0;

        this.screen = "menu";
    }

    //# ------------------------------------------------------------------
    //# Botones de la consola

    public void upPressed() {
        if (screen.equals("menu")) {
            if (selectedGame > 0)
                selectedGame--;
       
        } else if (screen.equals("Mortal Maze")) {
            if (playerY > 1) {
                playerY--;
                checkMazeFinished();
            }
        
        } else if (screen.equals("Space Invaders")) {
            fire();
        }

    }

    public void downPressed() {
        if (screen.equals("menu")) {
            if (selectedGame < games.size() - 1)
                selectedGame++;
        
        } else if (screen.equals("Mortal Maze")) {
            if (playerY < HEIGHT - 2) {
                playerY++;
                checkMazeFinished();
            }
        }
    }

    public void leftPressed() {
    	if (screen.equals("Mortal Maze")) {
            if (playerX > 1) {
                playerX--;
                checkMazeFinished();
            }

        } else if (screen.equals("F1 Grand Prix")) {
            carX--;
            carY--; // Avanzar
            checkCarPosition();

        } else if (screen.equals("Space Invaders")) {
            if (shipX > 0)
                shipX--;
        }
    }

    public void rightPressed() {
        if (screen.equals("menu")) {
            setScreen(games.get(selectedGame));

        } else if (screen.equals("Mortal Maze")) {
            if (playerX < WIDTH - 2) {
                playerX++;
                checkMazeFinished();
            }

        } else if (screen.equals("F1 Grand Prix")) {
            carX++;
            carY--; // Avanzar
            checkCarPosition();
       
        } else if (screen.equals("Space Invaders")) {
            if (shipX < enemiesMap.size() - 1)
                shipX++;
        }
    }

    public void backPressed() {
        if (screen.equals("menu")) {
            exit = true;
        } else
            setScreen("menu");
    }

    //# ------------------------------------------------------------------
    //# Otros métodos de la consola

    public boolean exit() {
        return exit;
    }

    public void draw() {
        if (screen.equals("menu")) {
            drawMenu();
        } else if (screen.equals("Mortal Maze")) {
            drawMaze();
        } else if (screen.equals("F1 Grand Prix")) {
            drawF1();
        } else if (screen.equals("Space Invaders")) {
            drawSpaceInvaders();
        }
    }

    public void gameFinished() {
        draw(); // Necesario para dibujar el último frame
        setScreen("menu");
    }

    void setScreen(String screen) {
        this.screen = screen;
        restart();
    }

    void restart() {
        if (screen.equals("Mortal Maze")) {

            System.out.println("----------------------------");
            System.out.println("Mortal Maze!!!");
            System.out.println("(W/S -> up/down. A/D -> left/right)");
            System.out.println("(C -> menu)");

            initializeMaze();

        } else if (screen.equals("F1 Grand Prix")) {

            System.out.println("----------------------------");
            System.out.println("F1 Grand Prix!!!");
            System.out.println("(A/D -> left/right)");
            System.out.println("(C -> menu)");

            initializeF1();

        } else if (screen.equals("Space Invaders")) {

            System.out.println("----------------------------");
            System.out.println("Space Invaders!!!");
            System.out.println("(W -> shoot. A/D -> left/right)");
            System.out.println("(C -> menu)");

            initializeSpaceInvaders();
        }
    }

    //# ------------------------------------------------------------------
    //# Métodos del Menú

    public void drawMenu() {
        System.out.println("\n--------------------");
        System.out.println("Select a game: (W/S -> up/down. D -> play game)");
        for (int i = 0; i < games.size(); i++) {
            System.out.print((i == selectedGame) ? " >> " : "    ");
            System.out.println(games.get(i));
        }
        System.out.println("(C -> turn off)");
    }

    //# ------------------------------------------------------------------
    //# Métodos de Mortal Maze

    private void initializeMaze() {
        playerX = playerY = 2;
        exitX = exitY = 4;
    }

    private void checkMazeFinished() {
        if (playerX == exitX && playerY == exitY) {
            gameFinished();
            System.out.println("You won!");
        }
    }

    public void drawMaze() {
        var map = new char[HEIGHT][WIDTH];

        // Fill first and last column with '#'
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = '#';
            map[map.length - 1][i] = '#';
        }

        // Fill inside lines with a border around and spaces inside
        for (int i = 1; i < map.length - 1; i++) {
            map[i][0] = '#';
            map[i][map[i].length - 1] = '#';
            for (int j = 1; j < map[i].length - 1; j++)
                map[i][j] = ' ';
        }

        // Put exit and player
        map[exitY][exitX] = 'X';
        map[playerY][playerX] = 'O';

        // draw all
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }

        System.out.println();
    }

    //# ------------------------------------------------------------------
    //# Métodos de F1 Grand Prix

    private void initializeF1() {
        carX = 5;
        carY = road.size() - 1;
    }

    private void checkCarPosition() {
        if (carY == 0) {
            gameFinished();
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

    public void drawF1() {
        for (int row = carY - ROWS_ABOVE; row <= carY + ROWS_BELOW; row++)
            drawRow(row);
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

    //# ------------------------------------------------------------------
    //# Métodos de Space Invaders

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

    private void fire() {

        if (barriersMap.get(shipX) > 0) {
            barriersMap.set(shipX, barriersMap.get(shipX) - 1);
            return;
        }

        if (enemiesMap.get(shipX) == EnemyCell.ENEMY) {
            enemiesMap.set(shipX, EnemyCell.EMPTY);

            if (enemiesMap.stream().noneMatch(content -> content == EnemyCell.ENEMY)) {
                gameFinished();
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
