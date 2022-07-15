package controller;

import constants.Constants;
import model.Bug;
import model.Direction;
import model.Fly;
import view.GamePanel;
import view.HUDPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class GameController {

    private MainController mainController;
    private GamePanel gamePanel;
    private HUDPanel hudPanel;
    // primo oggetto di Java Swing utilizzato per scandire i cicli ( update-repaint) di chiamata al paint component
    private Timer timer;
    private ArrayList<Bug> bugs;
    private int count;
    private int difficulty;
    private int level;

    public GameController(MainController mainController, GamePanel gamePanel, HUDPanel hudPanel, int difficulty, int firstLevel) {

        this.mainController = mainController;
        this.gamePanel = gamePanel;
        this.hudPanel = hudPanel;
        this.gamePanel.setGameController(this);
        this.difficulty = difficulty;
        this.level = firstLevel;
        this.count = (this.difficulty+1) * Constants.LOWER_BOUNDS_BUGS;
        this.bugs = new ArrayList<>();
        this.initializeGame();
    }

    private void initializeGame() {
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        //viene creato un thread specifico per la creazione di mosche e viene gestito con i semafori di java l'accesso all'array list per evitare collisioni (accesso concorrenziale)
        Thread flyCreator = new Thread(() -> {
            try {
                Bug b = null;
                Random r=new Random();
                while(true){
                    int size = 0;
                    synchronized (this.bugs) {
                        size = this.bugs.size();
                    }
                    if (size <= 10 * (difficulty + 1)-2) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Fly(randX, randY, Direction.SOUTH, difficulty);
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(500);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Fly(randX, 350 + randY, Direction.NORTH, difficulty);
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        this.timer.start();
        flyCreator.start();
    }

    // start update-repaint
    public void doOneLoop() {
        this.gamePanel.requestFocus();
        this.update();
        this.gamePanel.repaint();
        this.hudPanel.repaint();
    }

    private void update() {
        synchronized (this.bugs){
            for (Bug b:this.bugs) {
                b.move();
            }
        }
    }
    //tiene la posizione del mouse
    public void handleClick( int x, int y){
        Bug deadBug = null;
        synchronized (this.bugs) {
            for (Bug b : this.bugs) {
                if (b.isClicked(x, y)) {
                    b.die();
                    this.count--;
                    deadBug = b;
                }
            }
        }
        if(deadBug != null){
            this.bugs.remove(deadBug);
            this.gamePanel.removeBug(deadBug);
        }
    }
}
