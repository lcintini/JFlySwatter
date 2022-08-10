package controller;

import constants.Constants;
import utilities.Utilities;
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
        this.startMenu();
    }

    public void readHighScore(int difficulty) {
        String fileName = new String();
        switch (difficulty){
            case 0:
                fileName = Constants.EASY_HIGH_SCORE_PATH;
                break;
            case 1:
                fileName = Constants.NORMAL_HIGH_SCORE_PATH;
                break;
            case 2:
                fileName = Constants.HARD_HIGH_SCORE_PATH;
        }
        this.highScore = Utilities.readNumber(fileName);
    }

    public void startMenu(){
        this.menuPanel = new MenuPanel();
        this.mainView.addMenuPanel(this.menuPanel);
        this.menuController = new MenuController(this, this.menuPanel);
    }

    public void startGame(int difficulty, boolean effectsEnable, boolean musicEnable) {
        this.readHighScore(difficulty);
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

    public void updateHighScore(int level, int difficulty) {
        if(level > this.highScore){
            String fileName = new String();
            switch (difficulty){
                case 0:
                    fileName = Constants.EASY_HIGH_SCORE_PATH;
                    break;
                case 1:
                    fileName = Constants.NORMAL_HIGH_SCORE_PATH;
                    break;
                case 2:
                    fileName = Constants.HARD_HIGH_SCORE_PATH;
            }
            Utilities.writeNumber(fileName, level);
        }
    }
}
