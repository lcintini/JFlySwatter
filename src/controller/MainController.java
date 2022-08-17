package controller;

import constants.Constants;
import utilities.Utilities;
import view.*;


public class MainController {

    private MainView mainView;
    private MenuPanel menuPanel;
    private MenuController menuController;

    private GamePanel gamePanel;
    private GameController gameController;

    private HUDPanel hudPanel;
    private PausePanel pausePanel;

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
        this.menuController = new MenuController(this, this.menuPanel);
        this.mainView.addMenuPanel(this.menuPanel, this.menuController);
    }

    public void startGame(int difficulty, boolean effectsEnable, boolean musicEnable) {
        this.readHighScore(difficulty);
        this.gamePanel = new GamePanel();
        this.hudPanel = new HUDPanel();
        this.gameController = new GameController(this, this.gamePanel,this.hudPanel, difficulty, Constants.FIRST_LEVEL, effectsEnable, musicEnable);
        this.mainView.addGamePanel(this.gamePanel, this.hudPanel, this.gameController);
    }

    public void pauseGame() {
        this.pausePanel = new PausePanel(this.gameController.isMusicEnable(), this.gameController.isEffectsEnable());
        this.mainView.addPausePanel(pausePanel);
    }

    public void resumeGame() {
        this.mainView.removePausePanel(this.pausePanel);
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
}
