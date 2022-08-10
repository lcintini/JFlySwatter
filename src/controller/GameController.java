package controller;

import constants.Constants;
import model.*;
import utilities.Utilities;
import view.GamePanel;
import view.HUDPanel;
import view.PausePanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GameController {


    private MainController mainController;
    private GamePanel gamePanel;
    private HUDPanel hudPanel;
    private PausePanel pausePanel;
    private GameModel gameModel;
    // primo oggetto di Java Swing utilizzato per scandire i cicli ( update-repaint) di chiamata al paint component
    private Timer timer;
    private ArrayList<Bug> bugs;
    private ArrayList <Thread> threadCreators;
    private Clip musicClip;

    public GameController(MainController mainController, GamePanel gamePanel, HUDPanel hudPanel, int difficulty, int firstLevel, boolean effectsEnable, boolean musicEnable) {

        this.mainController = mainController;
        this.gamePanel = gamePanel;
        this.hudPanel = hudPanel;
        this.gamePanel.setGameController(this);
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.gameModel = new GameModel(difficulty, firstLevel, musicEnable, effectsEnable);
        this.initializeGame();
    }

    private void initializeGame() {
        this.gameModel.setCount((this.gameModel.getDifficulty()+1) * Constants.LOWER_BOUNDS_BUGS);
        this.bugs = new ArrayList<>();
        this.hudPanel.getCount().setText("Count: "+ this.gameModel.getCount());
        this.gameModel.setHighScore(this.mainController.getHighScore());
        this.hudPanel.printHighScore(this.gameModel.getHighScore());
        this.gameModel.setTimerLeft((int) ((1 / ((double) (this.gameModel.getDifficulty() + 1))) * Constants.LOWER_BOUNDS_TIMER));
        System.out.println(this.gameModel.getTimerLeft());
        this.hudPanel.getTimer().setText("Timer: "+ this.gameModel.getTimerLeft());
        //viene creato un thread specifico per la creazione di mosche e viene gestito con i semafori di java l'accesso all'array list per evitare collisioni (accesso concorrenziale)
        this.createThreads();
        this.gameModel.setStartTime(System.currentTimeMillis());
        this.timer.start();
        for(Thread t: this.threadCreators){
            t.start();
        }
        this.playMusic("bumblebee");
    }

    public void createThreads(){
        Thread flyCreator = new Thread(() -> {
            try {
                Bug b = null;
                Random r=new Random();
                while(true){
                    int size = 0;
                    synchronized (this.bugs) {
                        size = this.bugs.size();
                    }
                    if ((size <= 10 * (this.gameModel.getDifficulty() + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Fly(randX, randY, Direction.SOUTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(500);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Fly(randX, 350 + randY, Direction.NORTH, this.gameModel.getDifficulty());
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
        Thread waspCreator = new Thread(() -> {
            try {
                Bug b = null;
                Random r=new Random();
                Thread.sleep(8000);
                while(true){
                    int size = 0;
                    synchronized (this.bugs) {
                        size = this.bugs.size();
                    }
                    if ((size <= 10 * (this.gameModel.getDifficulty() + 1)-2) && (timer.isRunning())) {
                        synchronized (this.bugs) {
                            b = new Wasp(0, Constants.BORDER_Y1, Direction.EAST, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        synchronized (this.bugs) {
                            b = new Wasp(Constants.BOARD_WIDTH, Constants.BORDER_Y2-Constants.WASP_HEIGHT, Direction.WEST, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                    }
                }
            } catch (InterruptedException e) {
                //
            }
        });
        Thread butterflyCreator = new Thread(() -> {
            try {
                Bug b = null;
                Random r=new Random();
                Thread.sleep(5000);
                while(true){
                    int size = 0;
                    synchronized (this.bugs) {
                        size = this.bugs.size();
                    }
                    if ((size <= 10 * (this.gameModel.getDifficulty() + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Butterfly(randX, randY, Direction.SOUTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Butterfly(randX, 350 + randY, Direction.NORTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                    }
                }
            } catch (InterruptedException e) {
                //
            }
        });
        Thread ladybugCreator = new Thread(() -> {
            try {
                Bug b = null;
                Random r=new Random();
                Thread.sleep(5000);
                while(true){
                    int size = 0;
                    synchronized (this.bugs) {
                        size = this.bugs.size();
                    }
                    if ((size <= 10 * (this.gameModel.getDifficulty() + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Ladybug(randX, randY, Direction.SOUTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Ladybug(randX, 350 + randY, Direction.NORTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                    }
                }
            } catch (InterruptedException e) {
                //
            }
        });
        Thread cockroachCreator = new Thread(() -> {
            try {
                Bug b = null;
                Random r=new Random();
                Thread.sleep(5000);
                while(true){
                    int size = 0;
                    synchronized (this.bugs) {
                        size = this.bugs.size();
                    }
                    if ((size <= 10 * (this.gameModel.getDifficulty() + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Cockroach(randX, randY, Direction.SOUTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Cockroach(randX, 350 + randY, Direction.NORTH, this.gameModel.getDifficulty());
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                    }
                }
            } catch (InterruptedException e) {
                //
            }
        });
        this.threadCreators = new ArrayList<>();
        this.threadCreators.add(flyCreator);
        this.threadCreators.add(waspCreator);
        this.threadCreators.add(butterflyCreator);
        if(this.gameModel.getLevel() >= 3){
            this.threadCreators.add(ladybugCreator);
        }
        if(this.gameModel.getLevel() >= 4 ){
            this.threadCreators.add(cockroachCreator);
        }

    }

    // start update-repaint
    public void doOneLoop() {
        //si svegliano gli actionlistener del gamepanel
        this.gamePanel.requestFocus();
        this.update();
        this.mainController.nextCursor();
        this.gamePanel.repaint();
        this.hudPanel.repaint();
    }
    //aggiorna le coordinate degli insetti
    private void update() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int mouseX = (int)(p.getX() - this.gamePanel.getLocationOnScreen().getX());
        int mouseY = (int)(p.getY() - this.gamePanel.getLocationOnScreen().getY());
        synchronized (this.bugs){
            for (Bug b:this.bugs) {
                b.move(mouseX, mouseY);
            }
        }
        //aggiorno la label del tempo e controllo che il tempo non sia finito
        this.handleTimer();
    }

    private void handleTimer() {
        if(System.currentTimeMillis() >= this.gameModel.getStartTime() +1000){
            this.gameModel.setTimerLeft(this.gameModel.getTimerLeft() - 1);
            this.hudPanel.getTimer().setText("Timer: "+ this.gameModel.getTimerLeft());
            this.gameModel.setStartTime(System.currentTimeMillis());
        }
        //sconfitta
        if(this.gameModel.getTimerLeft() <= 0){
            this.timer.stop();
            System.out.println("il gioco è finito");
            this.stopMusic();
            // ferma il thread di creazione mosche
            this.hudPanel.printGameOver();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.hudPanel.hideGameOver();
            this.exitGame();
        }
    }

    //tiene la posizione del mouse
    public void handleClick( int x, int y){
        Bug deadBug = null;
        Swatter.setNormalAnimation(true);
        synchronized (this.bugs) {
            for (Bug b : this.bugs) {
                if (b.isClicked(x, y)) {
                    Swatter.setSwatAnimation(true);
                    this.playEffects("slap");
                    if(b.getPoints()==Constants.POINTS_LADYBUG){
                        this.gameModel.setTimerLeft(this.gameModel.getTimerLeft() - Constants.POINTS_LADYBUG);
                        this.hudPanel.getTimer().setText("Timer: "+ this.gameModel.getTimerLeft());
                    }
                    else if(b.getPoints()==Constants.POINTS_COCKROACH){
                        if(y < b.getY()+ Constants.COCKROACH_HEIGHT/2){
                            this.gameModel.setCount(this.gameModel.getCount() - Constants.POINTS_COCKROACH/2);
                            this.hudPanel.getCount().setText("Count: "+ this.gameModel.getCount());
                        }
                        else{
                            this.gameModel.setTimerLeft(this.gameModel.getTimerLeft() - Constants.POINTS_COCKROACH);
                            this.hudPanel.getTimer().setText("Timer: "+ this.gameModel.getTimerLeft());
                        }
                    }
                    else{
                        this.gameModel.setCount(this.gameModel.getCount() - b.getPoints());
                        this.hudPanel.getCount().setText("Count: "+ this.gameModel.getCount());
                    }
                    deadBug = b;
                }
            }
        }
        if(deadBug != null){
            this.bugs.remove(deadBug);
            this.gamePanel.removeBug(deadBug);
        }
        //vincita
        if(this.gameModel.getCount() <= 0) {
            this.stopMusic();
            this.timer.stop();
            this.gameModel.setLevel(this.gameModel.getLevel()+1);
            // ferma il thread di creazione mosche
            for(Thread t: this.threadCreators){
                t.interrupt();
            }
            this.bugs = new ArrayList<>();
            this.gamePanel.removeAllBugs();
            this.hudPanel.printVictory();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.hudPanel.hideVictory();
            this.initializeGame();
        }
    }

    public void pauseGame(){
        this.stopMusic();
        this.timer.stop();
        this.pausePanel = new PausePanel(this.gameModel.isMusicEnable(), this.gameModel.isEffectsEnable());
        JButton resumeButton= this.pausePanel.getResumeButton();
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects("slap");
                resumeGame();
            }
        });
        JButton exitButton= this.pausePanel.getExitButton();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects("slap");
                exitGame();
            }
        });
        JButton musicButton= this.pausePanel.getMusicButton();
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects("slap");
                gameModel.setMusicEnable(!gameModel.isMusicEnable());
                pausePanel.setMusicEnable(gameModel.isMusicEnable());
            }
        });
        JButton effectsButton= this.pausePanel.getEffectsButton();
        effectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModel.setEffectsEnable(!gameModel.isEffectsEnable());
                playEffects("slap");
                pausePanel.setEffectEnable(gameModel.isEffectsEnable());
            }
        });
        this.mainController.pauseGame(this.pausePanel);
    }


    private void resumeGame() {
        this.mainController.resumeGame(this.pausePanel);
        this.playMusic("bumblebee");
        this.timer.start();

    }
    private void exitGame() {
        for(Thread t: this.threadCreators){
            t.interrupt();
        }
        this.bugs = new ArrayList<>();
        this.gamePanel.removeAllBugs();
        this.mainController.updateHighScore(this.gameModel.getLevel(), this.gameModel.getDifficulty());
        this.mainController.startMenu();
    }
    public void playEffects(String sound) {
        if (this.gameModel.isEffectsEnable()) {
            Utilities.playEffects(sound);
        }
    }
    public void playMusic(String music) {
        this.musicClip = null;
        if (this.gameModel.isMusicEnable()) {
            this.musicClip = Utilities.playMusic(music);
        }
    }
    public void stopMusic(){
        if(this.musicClip!= null) {
            this.musicClip.stop();
        }
    }
}
