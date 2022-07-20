package controller;

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
    private Clip clip;
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

    private void initializeMenu() {
        String[] difficulties = {"Easy","Normal","Hard"};
        String soundName = "resources/sounds/slap.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            this.clip = AudioSystem.getClip();
            this.clip.open(audioInputStream);
            //non supporta l'audio
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
            //non legge il file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JButton startButton= this.menuPanel.getStartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(effectsEnable) {
                    clip.start();
                }
                mainController.startGame(difficulty);
            }
        });
        JButton rightArrowButton= this.menuPanel.getRightArrowButton();
        rightArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(effectsEnable) {
                    clip.start();
                }
                difficulty = (difficulty +1)%3; //modulo per gestire il livello circolarmente
                startButton.setText("Start "+ difficulties[difficulty] + " Mode");
            }
        });
        JButton leftArrowButton= this.menuPanel.getLeftArrowButton();
        leftArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(effectsEnable) {
                    clip.start();
                }
                difficulty = (difficulty -1)%3; //modulo per gestire il livello circolarmente
                startButton.setText("Start "+ difficulties[difficulty] + " Mode");;
            }
        });
        JButton musicButton= this.menuPanel.getMusicButton();
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(effectsEnable) {
                    clip.start();
                }
                musicEnable = !musicEnable;
                menuPanel.setMusicEnable(musicEnable);
            }
        });
        JButton effectsButton= this.menuPanel.getEffectsButton();
        effectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                effectsEnable = !effectsEnable;
                if(effectsEnable) {
                    clip.start();
                }
                menuPanel.setEffectEnable(effectsEnable);
            }
        });

    }


}
