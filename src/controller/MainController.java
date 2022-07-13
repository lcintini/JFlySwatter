package controller;

import view.MainView;
import view.MenuPanel;

public class MainController {

    private MainView mainView;
    private MenuPanel menuPanel;
    private MenuController menuController;


    public MainController() {
        this.mainView = new MainView();
        this.menuPanel = new MenuPanel();
        this.mainView.addMenuPanel(this.menuPanel);
        this.menuController = new MenuController(this, this.menuPanel);
    }


}
