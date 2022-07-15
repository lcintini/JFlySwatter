package controller;

import view.MenuPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {

    private MainController mainController;
    private MenuPanel menuPanel;
    private int difficulty;


    public MenuController(MainController mainController, MenuPanel menuPanel) {
        this.mainController = mainController;
        this.menuPanel = menuPanel;
        this.difficulty = 1;
        this.initializeMenu();
    }

    private void initializeMenu() {
        String[] difficulties = {"Easy","Normal","Hard"};
        JButton startButton= this.menuPanel.getStartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainController.startGame(difficulty);
            }
        });
        JButton rightArrowButton= this.menuPanel.getRightArrowButton();
        rightArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                difficulty = (difficulty +1)%3; //modulo per gestire il livello circolarmente
                startButton.setText("Start "+ difficulties[difficulty] + " Mode");
            }
        });
        JButton leftArrowButton= this.menuPanel.getLeftArrowButton();
        leftArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty = (difficulty -1)%3; //modulo per gestire il livello circolarmente
                startButton.setText("Start "+ difficulties[difficulty] + " Mode");;
            }
        });

    }


}
