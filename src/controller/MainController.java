package controller;

import view.GamePanel;
import view.MainView;
import view.MenuPanel;

public class MainController {

    private MainView mainView;
    private MenuPanel menuPanel;
    private MenuController menuController;

    private GamePanel gamePanel;


    public MainController() {
        this.mainView = new MainView();
        this.menuPanel = new MenuPanel();
        this.mainView.addMenuPanel(this.menuPanel);
        this.menuController = new MenuController(this, this.menuPanel);
    }


    public void startGame() {
        this.gamePanel = new GamePanel();
        this.mainView.addGamePanel(this.gamePanel);
    }
}
