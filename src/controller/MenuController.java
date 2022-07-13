package controller;

import view.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

    private MainController mainController;
    private MenuPanel menuPanel;


    public MenuController(MainController mainController, MenuPanel menuPanel) {
        this.mainController = mainController;
        this.menuPanel = menuPanel;
        this.initializeMenu();
    }

    private void initializeMenu() {
        JButton startButton= this.menuPanel.getStartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.startGame();
            }
        });
    }


}
