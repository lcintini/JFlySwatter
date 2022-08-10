package controller;

import constants.Constants;
import view.*;

import java.io.*;

public class MainController {

    private MainView mainView;
    private MenuPanel menuPanel;
    private MenuController menuController;

    private GamePanel gamePanel;
    private GameController gameController;

    private HUDPanel hudPanel;

    private int highScore;


    public MainController() {
        this.mainView = new MainView();
        this.highScore = 0;
        this.readRecord();
        this.startMenu();
    }

    public void readRecord() {
        BufferedReader in = null;
        try {
            in= new BufferedReader(new FileReader(Constants.HIGH_SCORE_PATH));
            //prende una stringa e la converte in un numero
            this.highScore = Integer.parseInt(in.readLine());
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startMenu(){
        this.menuPanel = new MenuPanel();
        this.mainView.addMenuPanel(this.menuPanel);
        this.menuController = new MenuController(this, this.menuPanel);
    }


    public void startGame(int difficulty, boolean effectsEnable, boolean musicEnable) {
        this.gamePanel = new GamePanel();
        this.hudPanel = new HUDPanel();
        this.mainView.addGamePanel(this.gamePanel,this.hudPanel);
        this.gameController = new GameController(this, this.gamePanel,this.hudPanel, difficulty, Constants.FIRST_LEVEL, effectsEnable, musicEnable);

    }

    public void pauseGame(PausePanel pausePanel) {

        this.mainView.addPausePanel(pausePanel);
    }

    public void resumeGame(PausePanel pausePanel) {

        this.mainView.removePausePanel(pausePanel);
    }
    public void nextCursor (){
        this.mainView.nextCursor();
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void updateHighScore(int level) {
        if(level > this.highScore){
            this.highScore = level;
            PrintWriter out = null;
            //deve sovrascrivere il file
            try {
                out = new PrintWriter(new FileOutputStream(Constants.HIGH_SCORE_PATH , false));
                out.print(this.highScore);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
