package controller;

import view.MainView;
import view.MenuPanel;

public class MainController {

    //il MainView serve per creare il frame (la finestrella)
    private MainView mainView;
    // 
    private MenuPanel menuPanel;


    public MainController() {
        this.mainView = new MainView();
        this.menuPanel=new MenuPanel();
        this.mainView.addMenuPanel(this.menuPanel);
    }


}
