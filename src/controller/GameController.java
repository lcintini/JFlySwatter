package controller;

import constants.Constants;
import view.GamePanel;

import javax.swing.*;

public class GameController {

    private MainController mainController;
    private GamePanel gamePanel;
    // primo oggetto di Java Swing utilizzato per scandire i cicli ( update-repaint) di chiamata al paint component
    private Timer timer;

    public GameController(MainController mainController, GamePanel gamePanel) {

        this.mainController = mainController;
        this.gamePanel = gamePanel;
        this.initializeGame();
    }

    private void initializeGame() {
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.timer.start();
    }

    // start update-repaint
    public void doOneLoop() {
        this.gamePanel.requestFocus();
        this.update();
        this.gamePanel.repaint();
    }

    private void update() {
    }

}
