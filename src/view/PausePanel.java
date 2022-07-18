package view;

import constants.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PausePanel extends JPanel {
    private JButton resumeButton;
    private JButton exitButton;
    private JButton musicButton;
    private JButton effectsButton;
    private boolean musicEnable;
    private boolean effectEnable;


    public PausePanel(boolean musicEnable, boolean effectEnable) {
        Color celeste= new Color(15, 212, 196);
        this.setBackground(celeste);
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.musicEnable = musicEnable;
        this.effectEnable = effectEnable;
        this.drawMenu();


    }

    private void drawMenu() {
        this.resumeButton = new JButton("Resume Game");
        this.resumeButton.setBackground(Color.WHITE);
        this.resumeButton.setForeground(Color.BLACK);
        this.resumeButton.setBorder(new LineBorder(Color.BLACK));
        this.resumeButton.setBounds(100, 200, 440, 80 );
        this.resumeButton.setFocusPainted(false);
        this.add(this.resumeButton);
        this.exitButton = new JButton("Exit Game");
        this.exitButton.setBackground(Color.WHITE);
        this.exitButton.setForeground(Color.BLACK);
        this.exitButton.setBorder(new LineBorder(Color.BLACK));
        this.exitButton.setBounds(100, 290, 440, 50 );
        this.exitButton.setFocusPainted(false);
        this.add(this.exitButton);
        if(this.musicEnable){
            this.musicButton = new JButton("Music OFF");
        }else{
            this.musicButton = new JButton("Music ON");
        }
        this.musicButton.setBackground(Color.WHITE);
        this.musicButton.setForeground(Color.BLACK);
        this.musicButton.setBorder(new LineBorder(Color.BLACK));
        this.musicButton.setBounds(100, 350, 200, 50 );
        this.musicButton.setFocusPainted(false);
        this.add(this.musicButton);
        if(this.effectEnable){
            this.effectsButton = new JButton("Effects OFF");
        }else{
            this.effectsButton = new JButton("Effects ON");
        }
        this.effectsButton.setBackground(Color.WHITE);
        this.effectsButton.setForeground(Color.BLACK);
        this.effectsButton.setBorder(new LineBorder(Color.BLACK));
        this.effectsButton.setBounds(340, 350, 200, 50 );
        this.effectsButton.setFocusPainted(false);
        this.add(this.effectsButton);
    }

    public JButton getResumeButton() {
        return this.resumeButton;
    }

    public JButton getExitButton() {
        return this.exitButton;
    }

    public JButton getMusicButton() {
        return this.musicButton;
    }

    public JButton getEffectsButton() {
        return this.effectsButton;
    }

    public void setMusicEnable(boolean musicEnable) {
        this.musicEnable = musicEnable;
        if(this.musicEnable){
            this.musicButton.setText("Music OFF");
        }else{
            this.musicButton.setText("Music ON");
        }
    }

    public void setEffectEnable(boolean effectEnable) {
        this.effectEnable = effectEnable;
        if(this.effectEnable){
            this.effectsButton.setText("Effects OFF");
        }else{
            this.effectsButton.setText("Effects ON");
        }
    }
}
