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
    private Thread flyCreator;
    private int timerLeft;
    private long startTime;


    public GameController(MainController mainController, GamePanel gamePanel, HUDPanel hudPanel, int difficulty, int firstLevel) {

        this.mainController = mainController;
        this.gamePanel = gamePanel;
        this.hudPanel = hudPanel;
        this.gamePanel.setGameController(this);
        this.difficulty = difficulty;
        this.level = firstLevel;
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.initializeGame();
    }

    private void initializeGame() {
        this.count = (this.difficulty+1) * Constants.LOWER_BOUNDS_BUGS;
        this.bugs = new ArrayList<>();
        this.hudPanel.getCount().setText("Count: "+ this.count);
        this.timerLeft = (int)((1/((double)(this.difficulty+1)))* Constants.LOWER_BOUNDS_TIMER);
        System.out.println(this.timerLeft);
        this.hudPanel.getTimer().setText("Timer: "+ this.timerLeft);
        //viene creato un thread specifico per la creazione di mosche e viene gestito con i semafori di java l'accesso all'array list per evitare collisioni (accesso concorrenziale)
        this.createThreads();
        this.startTime = System.currentTimeMillis();
        this.timer.start();
        this.flyCreator.start();
        /*if(this.level > 1){
            this.butterflyCreator.start();
        }*/
    }

    public void createThreads(){
        this.flyCreator = new Thread(() -> {
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
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                //
            }
        });
        // TODO Vespa
        // TODO Farfalla
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
        this.handleTimer();
    }

    private void handleTimer() {
        if(System.currentTimeMillis() >= this.startTime +1000){
            this.timerLeft--;
            this.hudPanel.getTimer().setText("Timer: "+ this.timerLeft);
            this.startTime = System.currentTimeMillis();
        }
        if(this.timerLeft == 0){
            this.timer.stop();
            System.out.println("il gioco è finito");
            // ferma il thread di creazione mosche
            this.flyCreator.interrupt();
            this.bugs = new ArrayList<>();
            this.gamePanel.removeAllBugs();
            this.mainController.startMenu();
        }
    }

    //tiene la posizione del mouse
    public void handleClick( int x, int y){
        Bug deadBug = null;
        synchronized (this.bugs) {
            for (Bug b : this.bugs) {
                if (b.isClicked(x, y)) {
                    b.die();
                    this.count-=b.getPoints();
                    this.hudPanel.getCount().setText("Count: "+ this.count);
                    deadBug = b;
                }
            }
        }
        if(deadBug != null){
            this.bugs.remove(deadBug);
            this.gamePanel.removeBug(deadBug);
        }
        if(this.count <= 0){
            this.timer.stop();
            this.level++;
            // ferma il thread di creazione mosche
            this.flyCreator.interrupt();
            this.bugs = new ArrayList<>();
            this.gamePanel.removeAllBugs();
            this.initializeGame();
        }
    }
}
