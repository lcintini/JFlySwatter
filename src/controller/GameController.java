package controller;

import constants.Constants;
import model.Bug;
import model.BugsCreator;
import utilities.Direction;
import model.GameModel;
import utilities.Utilities;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;

public class GameController {
    
    private MainController mainController;
    private GameModel gameModel;
    // primo oggetto di Java Swing utilizzato per scandire i cicli ( update-repaint) di chiamata al paint component
    private Timer timer;
    private ArrayList<Bug> bugs;
    private BugsCreator bugsCreator;
    private ArrayList <Timer> timerCreators;
    private boolean createNewBug;


    public GameController(MainController mainController, int difficulty, int firstLevel, boolean effectsEnable, boolean musicEnable) {

        this.mainController = mainController;
        this.bugsCreator = new BugsCreator();
        this.timer = new Timer(Constants.GAME_SPEED, e -> doOneLoop());
        this.gameModel = new GameModel(difficulty, firstLevel, musicEnable, effectsEnable);
        Utilities.registerFont();
        this.initializeGame();
    }

    public void initializeGame() {
        this.gameModel.setCount((this.gameModel.getDifficulty()+1) * Constants.LOWER_BOUNDS_BUGS);
        this.bugs = new ArrayList<>();
        this.gameModel.setLevel(this.gameModel.getLevel());
        this.mainController.getHudPanel().changeLevel("Level: "+ this.gameModel.getLevel());
        this.mainController.getHudPanel().changeCount("Count: "+ this.gameModel.getCount());
        this.gameModel.setHighScore(this.mainController.getHighScore());
        this.mainController.getHudPanel().printHighScore(this.gameModel.getHighScore());
        this.gameModel.setTimerLeft((int) ((1 / ((double) (this.gameModel.getDifficulty() + 1))) * Constants.LOWER_BOUNDS_TIMER));
        System.out.println(this.gameModel.getTimerLeft());
        this.mainController.getHudPanel().changeTimer("Timer: "+ this.gameModel.getTimerLeft());
        //vengono greati dei timer specifici per la creazione degli insetti
        this.createTimers();
        this.gameModel.setStartTime(System.currentTimeMillis());
        this.createNewBug = true;
        this.timer.start();
        for(Timer t: this.timerCreators){
            t.start();
        }
        this.playMusic("bumblebee");
    }

    public void createTimers(){
        Timer flyCreator = new Timer(Constants.GAME_SPEED / 2, e -> {
            Random r = new Random();
            int size = bugs.size();
            if ((size <= 10 * (gameModel.getDifficulty() + 1) - 2) && (timer.isRunning()) && createNewBug) {
                Bug b;
                createNewBug = false;
                int randX = r.nextInt(640);
                int randY = r.nextInt(30);
                int randPos = r.nextInt(2);
                if (randPos == 0) {
                    b = bugsCreator.createNewFly(randX, randY, Direction.SOUTH, gameModel.getDifficulty());
                } else {
                    b =bugsCreator.createNewFly(randX, 350 + randY, Direction.NORTH, gameModel.getDifficulty());
                }
                bugs.add(b);
                mainController.getGamePanel().addBug(b);
            }
        });
        Timer waspCreator = new Timer(Constants.GAME_SPEED / 2, e -> {
            Random r=new Random();
            int size = 0;
            size = bugs.size();
            int randPos = r.nextInt(2);
            if ((size <= 10 * (gameModel.getDifficulty() + 1)-2) && (timer.isRunning()) && createNewBug) {
                Bug b;
                createNewBug = false;
                if(randPos == 0){
                    b = bugsCreator.createNewWasp(0, Constants.BORDER_Y1, Direction.EAST, gameModel.getDifficulty());
                } else {
                    b = bugsCreator.createNewWasp(Constants.BOARD_WIDTH, Constants.BORDER_Y2-Constants.WASP_HEIGHT, Direction.WEST, gameModel.getDifficulty());
                }
                bugs.add(b);
                mainController.getGamePanel().addBug(b);
            }
        });
        Timer butterflyCreator = new Timer(Constants.GAME_SPEED / 2, e -> {
            Random r=new Random();
            int size = 0;
            size = bugs.size();
            int randPos = r.nextInt(2);
            if ((size <= 10 * (gameModel.getDifficulty() + 1)-2) && (timer.isRunning()) && createNewBug) {
                Bug b;
                createNewBug = false;
                int randX = r.nextInt(640);
                int randY = r.nextInt(30);
                if(randPos == 0){
                    b = bugsCreator.createNewButterfly(randX, randY, Direction.SOUTH, gameModel.getDifficulty());
                } else {
                    b = bugsCreator.createNewButterfly(randX, 350 + randY, Direction.NORTH, gameModel.getDifficulty());
                }
                bugs.add(b);
                mainController.getGamePanel().addBug(b);
            }
        });
        Timer ladybugCreator = new Timer(Constants.GAME_SPEED / 2, e -> {
            Random r=new Random();
            int size = 0;
            size = bugs.size();
            int randPos = r.nextInt(2);
            if ((size <= 10 * (gameModel.getDifficulty() + 1)-2) && (timer.isRunning()) && createNewBug) {
                Bug b;
                createNewBug = false;
                int randX = r.nextInt(640);
                int randY = r.nextInt(30);
                if(randPos == 0){
                    b = bugsCreator.createNewLadybug(randX, randY, Direction.SOUTH, gameModel.getDifficulty());
                } else {
                    b = bugsCreator.createNewLadybug(randX, 350 + randY, Direction.NORTH, gameModel.getDifficulty());
                }
                bugs.add(b);
                mainController.getGamePanel().addBug(b);
            }
        });
        Timer cockroachCreator = new Timer(Constants.GAME_SPEED / 2, e -> {
            Random r=new Random();
            int size = 0;
            size = bugs.size();
            int randPos = r.nextInt(2);
            if ((size <= 10 * (gameModel.getDifficulty() + 1)-2) && (timer.isRunning()) && createNewBug) {
                Bug b;
                createNewBug = false;
                int randX = r.nextInt(640);
                int randY = r.nextInt(30);
                if(randPos == 0){
                    b = bugsCreator.createNewCockroach(randX, randY, Direction.SOUTH, gameModel.getDifficulty());
                } else {
                    b = bugsCreator.createNewCockroach(randX, 350 + randY, Direction.NORTH, gameModel.getDifficulty());
                }
                bugs.add(b);
                mainController.getGamePanel().addBug(b);
            }
        });
        this.timerCreators = new ArrayList<>();
        this.timerCreators.add(flyCreator);
        this.timerCreators.add(waspCreator);
        if(this.gameModel.getLevel() >= 2){
            this.timerCreators.add(butterflyCreator);
        }
        if(this.gameModel.getLevel() >= 3){
            this.timerCreators.add(ladybugCreator);
        }
        if(this.gameModel.getLevel() >= 4 ){
            this.timerCreators.add(cockroachCreator);
        }
    }

    // start update-repaint
    public void doOneLoop() {
        //si svegliano gli actionlistener del mainController.getGamePanel()
        this.mainController.getGamePanel().requestFocus();
        this.update();
        this.mainController.nextCursor();
        this.mainController.getGamePanel().repaint();
        this.mainController.getHudPanel().repaint();
    }

    //aggiorna le coordinate degli insetti
    public void update() {
        int mouseX = this.mainController.getGamePanel().getMouseLocationX();
        int mouseY = this.mainController.getGamePanel().getMouseLocationY();
        for (Bug b:this.bugs) {
            b.move(mouseX, mouseY);
        }
        //aggiorno la label del tempo e controllo che il tempo non sia finito
        this.handleTimer();
    }

    public void handleTimer() {
        if(System.currentTimeMillis() >= this.gameModel.getStartTime() +1000){
            this.createNewBug = true;
            this.gameModel.setTimerLeft(this.gameModel.getTimerLeft() - 1);
            this.mainController.getHudPanel().changeTimer("Timer: "+ this.gameModel.getTimerLeft());
            this.gameModel.setStartTime(System.currentTimeMillis());
        }
        //sconfitta
        if(this.gameModel.getTimerLeft() <= 0){
            this.timer.stop();
            this.stopMusic();
            // ferma il timer di creazione mosche
            this.mainController.getHudPanel().printGameOver();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.mainController.getHudPanel().hideGameOver();
            this.exitGame();
        }
    }

    //tiene la posizione del mouse
    public void handleClick( int x, int y){
        Bug deadBug = null;
        this.mainController.setNormalSwatter();
        x += 16;
        y += 7;
        for (Bug b : this.bugs) {
            if (b.isClicked(x, y)) {
                this.mainController.setSwatSwatter();
                this.playEffects("slap");
                if(b.getPoints()==Constants.POINTS_LADYBUG){
                    this.gameModel.setTimerLeft(this.gameModel.getTimerLeft() - Constants.POINTS_LADYBUG);
                    this.mainController.getHudPanel().changeTimer("Timer: "+ this.gameModel.getTimerLeft());
                }
                else if(b.getPoints()==Constants.POINTS_COCKROACH){
                    if(y < b.getY()+ Constants.COCKROACH_HEIGHT/2){
                        this.gameModel.setCount(this.gameModel.getCount() - Constants.POINTS_COCKROACH/2);
                        this.mainController.getHudPanel().changeCount("Count: "+ this.gameModel.getCount());
                    }
                    else{
                        this.gameModel.setTimerLeft(this.gameModel.getTimerLeft() - Constants.POINTS_COCKROACH);
                        this.mainController.getHudPanel().changeTimer("Timer: "+ this.gameModel.getTimerLeft());
                    }
                }
                else{
                    this.gameModel.setCount(this.gameModel.getCount() - b.getPoints());
                    this.mainController.getHudPanel().changeCount("Count: "+ this.gameModel.getCount());
                }
                deadBug = b;
            }
        }
        if(deadBug != null){
            this.bugs.remove(deadBug);
            this.mainController.getGamePanel().removeBug(deadBug);
        }
        //vincita
        if(this.gameModel.getCount() <= 0) {
            this.stopMusic();
            this.timer.stop();
            this.gameModel.setLevel(this.gameModel.getLevel()+1);
            this.mainController.getHudPanel().changeLevel("Level: "+ this.gameModel.getLevel());
            // ferma il thread di creazione mosche
            for(Timer t: this.timerCreators){
                t.stop();
            }
            this.bugs = new ArrayList<>();
            this.mainController.getGamePanel().removeAllBugs();
            this.mainController.getHudPanel().printVictory();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.mainController.getHudPanel().hideVictory();
            this.initializeGame();
        }
    }

    public void pauseGame(){
        this.stopMusic();
        this.timer.stop();
        this.mainController.pauseGame();
    }

    public void resumeGame() {
        this.mainController.resumeGame();
        this.playMusic("bumblebee");
        this.timer.start();
    }

    public void exitGame() {
        for(Timer t: this.timerCreators){
            t.stop();
        }
        this.bugs = new ArrayList<>();
        this.mainController.getGamePanel().removeAllBugs();
        this.mainController.updateHighScore(this.gameModel.getLevel(), this.gameModel.getDifficulty());
        this.mainController.startMenu();
    }

    public void playEffects(String sound) {
        if (this.gameModel.isEffectsEnable()) {
            Utilities.playEffects(sound);
        }
    }

    public void playMusic(String music) {
        if (this.gameModel.isMusicEnable()) {
            Utilities.playMusic(music);
        }
    }

    public void stopMusic(){
        Utilities.stopMusic();
    }

    public void setMusicEnable(boolean b) {
        this.gameModel.setMusicEnable(b);
    }
    public boolean isMusicEnable() {
        return this.gameModel.isMusicEnable();
    }

    public void setEffectsEnable(boolean b) {
        this.gameModel.setEffectsEnable(b);
    }

    public boolean isEffectsEnable() {
        return this.gameModel.isEffectsEnable();
    }
}
