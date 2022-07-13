package controller;

import view.MenuPanel;

public class MenuController {

    private MainController mainController;
    private MenuPanel menuPanel;


    public MenuController(MainController mainController, MenuPanel menuPanel) {
        this.mainController = mainController;
        this.menuPanel = menuPanel;
    }
}
