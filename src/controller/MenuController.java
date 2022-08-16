package controller;

import utilities.Utilities;
import view.MenuPanel;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuController {

    private MainController mainController;
    private MenuPanel menuPanel;
    private int difficulty;
    private boolean musicEnable;
    private boolean effectsEnable;


    public MenuController(MainController mainController, MenuPanel menuPanel) {
        this.mainController = mainController;
        this.menuPanel = menuPanel;
        this.difficulty = 1;
        this.musicEnable = true;
        this.effectsEnable = true;
        this.initializeMenu();
    }

    public void initializeMenu() {
        String[] difficulties = {"Easy","Normal","Hard"};
        JButton startButton= this.menuPanel.getStartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects();
                mainController.startGame(difficulty, effectsEnable, musicEnable);
            }
        });
        JButton rightArrowButton= this.menuPanel.getRightArrowButton();
        rightArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects();
                difficulty = (Math.floorMod(difficulty+1, 3) + Math.abs(3)) % Math.abs(3); //modulo per gestire il livello circolarmente
                startButton.setText("Start "+ difficulties[difficulty] + " Mode");
            }
        });
        JButton leftArrowButton= this.menuPanel.getLeftArrowButton();
        leftArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects();
                difficulty =(Math.floorMod(difficulty-1, 3) + Math.abs(3)) % Math.abs(3); //modulo per gestire il livello circolarmente
                startButton.setText("Start "+ difficulties[difficulty] + " Mode");
            }
        });
        JButton musicButton= this.menuPanel.getMusicButton();
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playEffects();
                musicEnable = !musicEnable;
                menuPanel.setMusicEnable(musicEnable);
            }
        });
        JButton effectsButton= this.menuPanel.getEffectsButton();
        effectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                effectsEnable = !effectsEnable;
                playEffects();
                menuPanel.setEffectEnable(effectsEnable);
            }
        });

    }
    public void playEffects() {
        if (this.effectsEnable) {
            Utilities.playEffects("slap");
        }
    }


}
