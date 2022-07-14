package controller;

import constants.Constants;
import model.Direction;
import model.Fly;
import view.GamePanel;
import view.HUDPanel;

import javax.swing.*;

public class GameController {

    private MainController mainController;
    private GamePanel gamePanel;
    private HUDPanel hudPanel;
    // primo oggetto di Java Swing utilizzato per scandire i cicli ( update-repaint) di chiamata al paint component
    private Timer timer;
    private Fly fly;
    private int count;

    public GameController(MainController mainController, GamePanel gamePanel, HUDPanel hudPanel) {

        this.mainController = mainController;
        this.gamePanel = gamePanel;
        this.hudPanel = hudPanel;
        this.gamePanel.setGameController(this);
        this.count = 30;
        this.initializeGame();
    }

    private void initializeGame() {
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.fly = new Fly(640,0, Direction.SOUTH);
        this.gamePanel.addBug(fly);
        this.timer.start();

    }

    // start update-repaint
    public void doOneLoop() {
        this.gamePanel.requestFocus();
        this.update();
        this.gamePanel.repaint();
        this.hudPanel.repaint();
    }

    private void update() {

        this.fly.move();
    }
    //tiene la posizione del mouse
    public void handleClick( int x, int y){
        if (this.fly.isClicked(x,y)){
            this.fly.die();
            this.count--;
            this.fly = new Fly(640,0, Direction.SOUTH);
            this.gamePanel.addBug(fly);
        }
    }
}
