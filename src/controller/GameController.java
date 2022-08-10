package controller;

import constants.Constants;
import model.*;
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
    // primo oggetto di Java Swing utilizzato per scandire i cicli ( update-repaint) di chiamata al paint component
    private Timer timer;
    private ArrayList<Bug> bugs;
    private int count;
    private int difficulty;
    private int level;
    private ArrayList <Thread> threadCreators;
    private int timerLeft;
    private long startTime;
    private boolean musicEnable;
    private boolean effectsEnable;
    private Clip musicClip;
    private int highScore;



    public GameController(MainController mainController, GamePanel gamePanel, HUDPanel hudPanel, int difficulty, int firstLevel, boolean effectsEnable, boolean musicEnable) {

        this.mainController = mainController;
        this.gamePanel = gamePanel;
        this.hudPanel = hudPanel;
        this.gamePanel.setGameController(this);
        this.difficulty = difficulty;
        this.level = firstLevel;
        this.timer = new Timer(Constants.GAME_SPEED, new GameLoop(this));
        this.musicEnable = musicEnable;
        this.effectsEnable = effectsEnable;
        this.initializeGame();
    }

    private void initializeGame() {
        this.count = (this.difficulty+1) * Constants.LOWER_BOUNDS_BUGS;
        this.bugs = new ArrayList<>();
        this.hudPanel.getCount().setText("Count: "+ this.count);
        this.highScore = this.mainController.getHighScore();
        this.hudPanel.printHighScore(this.highScore);
        this.timerLeft = (int)((1/((double)(this.difficulty+1)))* Constants.LOWER_BOUNDS_TIMER);
        System.out.println(this.timerLeft);
        this.hudPanel.getTimer().setText("Timer: "+ this.timerLeft);
        //viene creato un thread specifico per la creazione di mosche e viene gestito con i semafori di java l'accesso all'array list per evitare collisioni (accesso concorrenziale)
        this.createThreads();
        this.startTime = System.currentTimeMillis();
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
                    if ((size <= 10 * (difficulty + 1)-2) && (timer.isRunning())) {
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
                    if ((size <= 10 * (difficulty + 1)-2) && (timer.isRunning())) {
                        synchronized (this.bugs) {
                            b = new Wasp(0, Constants.BORDER_Y1, Direction.EAST, difficulty);
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        synchronized (this.bugs) {
                            b = new Wasp(Constants.BOARD_WIDTH, Constants.BORDER_Y2-Constants.WASP_HEIGHT, Direction.WEST, difficulty);
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
                    if ((size <= 10 * (difficulty + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Butterfly(randX, randY, Direction.SOUTH, difficulty);
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Butterfly(randX, 350 + randY, Direction.NORTH, difficulty);
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
                    if ((size <= 10 * (difficulty + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Ladybug(randX, randY, Direction.SOUTH, difficulty);
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Ladybug(randX, 350 + randY, Direction.NORTH, difficulty);
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
                    if ((size <= 10 * (difficulty + 1)-2) && (timer.isRunning())) {
                        int randX = r.nextInt(640);
                        int randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Cockroach(randX, randY, Direction.SOUTH, difficulty);
                            bugs.add(b);
                            gamePanel.addBug(b);
                        }
                        Thread.sleep(5000);
                        randX = r.nextInt(640);
                        randY = r.nextInt(30);
                        synchronized (this.bugs) {
                            b = new Cockroach(randX, 350 + randY, Direction.NORTH, difficulty);
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
        if(this.level >= 3){
            this.threadCreators.add(ladybugCreator);
        }
        if(this.level >= 4 ){
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
        if(System.currentTimeMillis() >= this.startTime +1000){
            this.timerLeft--;
            this.hudPanel.getTimer().setText("Timer: "+ this.timerLeft);
            this.startTime = System.currentTimeMillis();
        }
        //sconfitta
        if(this.timerLeft <= 0){
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
                        this.timerLeft -= Constants.POINTS_LADYBUG;
                        this.hudPanel.getTimer().setText("Timer: "+ this.timerLeft);
                    }
                    else if(b.getPoints()==Constants.POINTS_COCKROACH){
                        if(y < b.getY()+ Constants.COCKROACH_HEIGHT/2){
                            this.count -= Constants.POINTS_COCKROACH/2;
                            this.hudPanel.getCount().setText("Count: "+ this.count);
                        }
                        else{
                            this.timerLeft -= Constants.POINTS_COCKROACH;
                            this.hudPanel.getTimer().setText("Timer: "+ this.timerLeft);
                        }
                    }
                    else{
                        this.count-=b.getPoints();
                        this.hudPanel.getCount().setText("Count: "+ this.count);
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
        if(this.count <= 0) {
            this.stopMusic();
            this.timer.stop();
            this.level++;
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
        this.pausePanel = new PausePanel(musicEnable, effectsEnable);
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
                musicEnable = !musicEnable;
                pausePanel.setMusicEnable(musicEnable);
            }
        });
        JButton effectsButton= this.pausePanel.getEffectsButton();
        effectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                effectsEnable = !effectsEnable;
                playEffects("slap");
                pausePanel.setEffectEnable(effectsEnable);
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
        this.mainController.updateHighScore(this.level);
        this.mainController.startMenu();
    }
    public void playEffects(String sound) {
        if (this.effectsEnable) {
            String soundName = "resources/sounds/"+sound+".wav";
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                //non supporta l'audio
            } catch (UnsupportedAudioFileException | LineUnavailableException e) {
                throw new RuntimeException(e);
                //non legge il file
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void playMusic(String music) {
        this.musicClip = null;
        if (this.musicEnable) {
            String soundName = "resources/music/"+music+".wav";
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
                this.musicClip = AudioSystem.getClip();
                this.musicClip.open(audioInputStream);
                this.musicClip.start();
                //non supporta l'audio
            } catch (UnsupportedAudioFileException | LineUnavailableException e) {
                throw new RuntimeException(e);
                //non legge il file
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stopMusic(){
        if(this.musicClip!= null) {
            this.musicClip.stop();
        }
    }
}
