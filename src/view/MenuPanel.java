package view;

import constants.Constants;
import utilities.Utilities;
import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton startButton;
    private JButton rightArrowButton;
    private JButton leftArrowButton;
    private JButton musicButton;
    private JButton effectsButton;
    private boolean musicEnable;
    private boolean effectEnable;
    private Image imgMenu;

    public MenuPanel() {
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.imgMenu = (Utilities.readImage(Constants.MENU_GRASS_PATH)).getImage();
        this.musicEnable = true;
        this.effectEnable = true;
        this.drawMenu();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //override
        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        g.drawImage(this.imgMenu,0,0,this);
        this.drawMenu();
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawMenu() {
        this.startButton = new JButton("");
        ImageIcon imgStartNormal = (Utilities.readImage(Constants.START_NORMAL_BUTTON_PATH));
        this.startButton.setIcon(imgStartNormal);
        this.startButton.setMargin(new Insets(0,0,0,0));
        this.startButton.setContentAreaFilled(false);
        this.startButton.setBorder(null);
        this.startButton.setBounds(100, 200, 440, 80 );
        this.startButton.setFocusPainted(false);
        this.add(this.startButton);
        ImageIcon imgRightArrow = Utilities.readImage(Constants.RIGHT_ARROW_PATH);
        this.rightArrowButton = new JButton("");
        this.rightArrowButton.setIcon(imgRightArrow);
        this.rightArrowButton.setBorder(null);
        this.rightArrowButton.setMargin(new Insets(0,0,0,0));
        this.rightArrowButton.setContentAreaFilled(false);
        this.rightArrowButton.setBounds(395, 290, 80, 50 );
        this.rightArrowButton.setFocusPainted(false);
        this.add(this.rightArrowButton);
        ImageIcon imgLeftArrow = Utilities.readImage(Constants.LEFT_ARROW_PATH);
        this.leftArrowButton = new JButton("");
        this.leftArrowButton.setIcon(imgLeftArrow);
        this.leftArrowButton.setBorder(null);
        this.leftArrowButton.setMargin(new Insets(0,0,0,0));
        this.leftArrowButton.setContentAreaFilled(false);
        this.leftArrowButton.setBounds(160, 290, 80, 50 );
        this.leftArrowButton.setFocusPainted(false);
        this.add(this.leftArrowButton);
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
        this.musicButton.setBounds(120, 350, 180, 50 );
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
        this.effectsButton.setBounds(340, 350, 180, 50 );
        this.effectsButton.setFocusPainted(false);
        this.add(this.effectsButton);
        this.repaint();
    }

    public JButton getStartButton() {
        return this.startButton;
    }

    public JButton getRightArrowButton() {
        return this.rightArrowButton;
    }

    public JButton getLeftArrowButton() {
        return this.leftArrowButton;
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
            this.effectsButton.paintImmediately(this.effectsButton.getVisibleRect());
        }else{
            ImageIcon imgEffectsOn = Utilities.readImage(Constants.EFFECTS_ON_PATH);
            this.effectsButton.setIcon(imgEffectsOn);
            this.effectsButton.paintImmediately(this.effectsButton.getVisibleRect());
        }
    }
}
