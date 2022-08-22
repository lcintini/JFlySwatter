package view;

import constants.Constants;
import utilities.Utilities;
import javax.swing.*;
import java.awt.*;

public class PausePanel extends JPanel {
    private JButton resumeButton;
    private JButton exitButton;
    private JButton musicButton;
    private JButton effectsButton;
    private boolean musicEnable;
    private boolean effectEnable;
    private Image imgPause;
    private JLabel pause;


    public PausePanel(boolean musicEnable, boolean effectEnable) {
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.musicEnable = musicEnable;
        this.effectEnable = effectEnable;
        this.drawMenu();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //override
        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        g.drawImage(this.imgPause,0,0,this);
        this.drawMenu();
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawMenu() {
        this.imgPause = (Utilities.readImage(Constants.PAUSE_GRASS_PATH)).getImage();
        Color marrone= new Color(151, 69, 45, 255);
        this.pause = new JLabel("Pause");
        this.pause.setBounds(270, 40, 100, 70);
        this.pause.setFont(new Font ("The Bomb", Font.BOLD, 17) );
        this.pause.setForeground(marrone);
        this.add(this.pause);
        this.resumeButton = new JButton("");
        ImageIcon imgResume = (Utilities.readImage(Constants.RESUME_BUTTON_PATH));
        this.resumeButton.setIcon(imgResume);
        this.resumeButton.setMargin(new Insets(0,0,0,0));
        this.resumeButton.setContentAreaFilled(false);
        this.resumeButton.setBorder(null);
        this.resumeButton.setBounds(100, 200, 440, 80 );
        this.resumeButton.setFocusPainted(false);
        this.add(this.resumeButton);
        this.exitButton = new JButton("Exit Game");
        ImageIcon imgExit = (Utilities.readImage(Constants.EXIT_BUTTON_PATH));
        this.exitButton.setIcon(imgExit);
        this.exitButton.setMargin(new Insets(0,0,0,0));
        this.exitButton.setContentAreaFilled(false);
        this.exitButton.setBorder(null);
        this.exitButton.setBounds(106, 290, 440, 50 );
        this.exitButton.setFocusPainted(false);
        this.add(this.exitButton);
        if(this.musicEnable){
            this.musicButton = new JButton("");
            ImageIcon imgMusicOff = Utilities.readImage(Constants.MUSIC_OFF_PATH);
            this.musicButton.setIcon(imgMusicOff);
        }else{
            this.musicButton = new JButton("");
            ImageIcon imgMusicOn = Utilities.readImage(Constants.MUSIC_ON_PATH);
            this.musicButton.setIcon(imgMusicOn);
        }
        this.musicButton.setBorder(null);
        this.musicButton.setMargin(new Insets(0,0,0,0));
        this.musicButton.setContentAreaFilled(false);
        this.musicButton.setBounds(110, 350, 200, 50 );
        this.musicButton.setFocusPainted(false);
        this.add(this.musicButton);
        if(this.effectEnable){
            this.effectsButton = new JButton("");
            ImageIcon imgEffectsOff = Utilities.readImage(Constants.EFFECTS_OFF_PATH);
            this.effectsButton = new JButton("");
            this.effectsButton.setIcon(imgEffectsOff);
        }else{
            this.effectsButton = new JButton("");
            ImageIcon imgEffectsOn = Utilities.readImage(Constants.EFFECTS_ON_PATH);
            this.effectsButton.setIcon(imgEffectsOn);
        }
        this.effectsButton.setBorder(null);
        this.effectsButton.setMargin(new Insets(0,0,0,0));
        this.effectsButton.setContentAreaFilled(false);
        this.effectsButton.setBounds(328, 350, 200, 50 );
        this.effectsButton.setFocusPainted(false);
        this.add(this.effectsButton);
        this.repaint();
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
            ImageIcon imgMusicOff = Utilities.readImage(Constants.MUSIC_OFF_PATH);
            this.musicButton.setIcon(imgMusicOff);
        }else{
            ImageIcon imgMusicOn = Utilities.readImage(Constants.MUSIC_ON_PATH);
            this.musicButton.setIcon(imgMusicOn);
        }
    }

    public void setEffectEnable(boolean effectEnable) {
        this.effectEnable = effectEnable;
        if(this.effectEnable){
            ImageIcon imgEffectsOff = Utilities.readImage(Constants.EFFECTS_OFF_PATH);
            this.effectsButton.setIcon(imgEffectsOff);

        }else{
            ImageIcon imgEffectsOn = Utilities.readImage(Constants.EFFECTS_ON_PATH);
            this.effectsButton.setIcon(imgEffectsOn);
        }
    }
}
