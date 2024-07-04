package console;

import java.util.*;

import state.StateGame;
import state.StateGameMenu;

public class GameAndWatch {

    String screen;
    boolean exit;
    StateGame estado;

    //# ------------------------------------------------------------------
    //# Variables del Menu

    private List<String> games;
    private int selectedGame;


    public GameAndWatch() {

        this.estado = new StateGameMenu();
    }

    //# ------------------------------------------------------------------
    //# Botones de la consola

    public void upPressed() {
       estado.upPressed();
    }

    public void downPressed() {
        estado.downPressed();
    }

    public void leftPressed() {
    	estado.leftPressed();
    }

    public void rightPressed() {
        estado.rightPressed();
    }

    public void backPressed() {
       estado.backPressed();
    }

    //# ------------------------------------------------------------------
    //# Otros métodos de la consola

    public boolean exit() {
        return exit;
    }

    public void draw() {
        estado.draw();
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
        estado.restart();
    }
}
