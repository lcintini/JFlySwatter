package controller;

import constants.Constants;
import view.GamePanel;
import view.HUDPanel;
import view.MainView;
import view.MenuPanel;

public class MainController {

    private MainView mainView;
    private MenuPanel menuPanel;
    private MenuController menuController;

    private GamePanel gamePanel;
    private GameController gameController;

    private HUDPanel hudPanel;


    public MainController() {
        this.mainView = new MainView();
        this.startMenu();
    }

    public void startMenu(){
        this.menuPanel = new MenuPanel();
        this.mainView.addMenuPanel(this.menuPanel);
        this.menuController = new MenuController(this, this.menuPanel);
    }


    public void startGame(int difficulty) {
        this.gamePanel = new GamePanel();
        this.hudPanel = new HUDPanel();
        this.mainView.addGamePanel(this.gamePanel,this.hudPanel);
        this.gameController = new GameController(this, this.gamePanel,this.hudPanel, difficulty, Constants.FIRST_LEVEL);

    }
}
