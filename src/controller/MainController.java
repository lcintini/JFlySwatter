package controller;

import constants.Constants;
import utilities.Utilities;
import view.*;

import java.awt.*;


public class MainController {

    private MainView mainView;

    private MenuController menuController;
    private GameController gameController;

    private int highScore;



    public MainController() {
        this.mainView = new MainView(this);
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
        MenuPanel menuPanel = new MenuPanel();
        this.menuController = new MenuController(this, menuPanel);
        this.mainView.addMenuPanel(menuPanel, this.menuController);
    }

    public void startGame(int difficulty, boolean effectsEnable, boolean musicEnable) {
        this.readHighScore(difficulty);
        HUDPanel hudPanel = new HUDPanel();
        GamePanel gamePanel = new GamePanel(this.mainView);
        this.mainView.addGamePanel(gamePanel, hudPanel);
        this.gameController = new GameController(this, difficulty, Constants.FIRST_LEVEL, effectsEnable, musicEnable);
    }

    public void pauseGame() {
        PausePanel pausePanel = new PausePanel(this.gameController.isMusicEnable(), this.gameController.isEffectsEnable());
        this.mainView.addPausePanel(pausePanel, this.gameController);
    }

    public void resumeGame() {
        this.mainView.removePausePanel();
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
    public void setNormalSwatter(){
        this.mainView.setNormalSwatter();
    }

    public void setSwatSwatter(){
        this.mainView.setSwatSwatter();
    }

    public GamePanel getGamePanel() {
        return this.mainView.getGamePanel();
    }

    public HUDPanel getHudPanel() {
        return this.mainView.getHudPanel();
    }

    public GameController getGameController() {
        return gameController;
    }

}
