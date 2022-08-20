package view;

import constants.Constants;
import utilities.Utilities;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
    private JLabel title;






    public MenuPanel() {
        Color celeste= new Color(151, 69, 45, 255);
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.imgMenu = (Utilities.readImage(Constants.MENU_GRASS_PATH)).getImage();
        this.title = new JLabel("JFlySwatter");
        this.title.setBounds(120, 93, 400, 70);
        this.title.setFont(new Font ("The Bomb", Font.BOLD, 40) );
        this.title.setForeground(celeste);
        this.add(this.title);
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
        //this.startButton = new JButton("Start Normal Mode");
        //this.startButton.setBackground(Color.WHITE);
        //this.startButton.setForeground(Color.BLACK);
        ImageIcon imgStartNormal = (Utilities.readImage(Constants.START_NORMAL_BUTTON_PATH));
        this.startButton.setIcon(imgStartNormal);
        this.startButton.setMargin(new Insets(0,0,0,0)); //nuova
        this.startButton.setContentAreaFilled(false); //nuova
        this.startButton.setBorder(null);
        //this.startButton.setBorder(new LineBorder(Color.BLACK));
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
            //this.musicButton = new JButton("Music OFF");
            this.musicButton = new JButton("");
            ImageIcon imgMusicOff = Utilities.readImage(Constants.MUSIC_OFF_PATH);
            this.musicButton.setIcon(imgMusicOff);
        }else{
            //this.musicButton = new JButton("Music ON");
            this.musicButton = new JButton("");
            ImageIcon imgMusicOn = Utilities.readImage(Constants.MUSIC_ON_PATH);
            this.musicButton.setIcon(imgMusicOn);
        }
        this.musicButton.setBorder(null);
        this.musicButton.setMargin(new Insets(0,0,0,0));
        this.musicButton.setContentAreaFilled(false);
        //this.musicButton.setBackground(Color.WHITE);
        //this.musicButton.setForeground(Color.BLACK);
        //this.musicButton.setBorder(new LineBorder(Color.BLACK));
        this.musicButton.setBounds(120, 350, 180, 50 );
        this.musicButton.setFocusPainted(false);
        this.add(this.musicButton);
        if(this.effectEnable){
            this.effectsButton = new JButton("Effects OFF");
            ImageIcon imgEffectsOff = Utilities.readImage(Constants.EFFECTS_OFF_PATH);
            this.effectsButton = new JButton("");
            this.effectsButton.setIcon(imgEffectsOff);
        }else{
            this.effectsButton = new JButton("Effects ON");
            ImageIcon imgEffectsOn = Utilities.readImage(Constants.EFFECTS_ON_PATH);
            this.effectsButton.setIcon(imgEffectsOn);
        }
        this.effectsButton.setBorder(null);
        this.effectsButton.setMargin(new Insets(0,0,0,0));
        this.effectsButton.setContentAreaFilled(false);
        /*this.effectsButton.setBackground(Color.WHITE);
        this.effectsButton.setForeground(Color.BLACK);
        this.effectsButton.setBorder(new LineBorder(Color.BLACK));*/
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
            //this.musicButton.setText("Music OFF");
            ImageIcon imgMusicOff = Utilities.readImage(Constants.MUSIC_OFF_PATH);
            this.musicButton.setIcon(imgMusicOff);
        }else{
            //this.musicButton.setText("Music ON");
            ImageIcon imgMusicOn = Utilities.readImage(Constants.MUSIC_ON_PATH);
            this.musicButton.setIcon(imgMusicOn);
        }
    }

    public void setEffectEnable(boolean effectEnable) {
        this.effectEnable = effectEnable;
        if(this.effectEnable){
            //this.effectsButton.setText("Effects OFF");
            ImageIcon imgEffectsOff = Utilities.readImage(Constants.EFFECTS_OFF_PATH);
            this.effectsButton.setIcon(imgEffectsOff);

        }else{
            //this.effectsButton.setText("Effects ON");
            ImageIcon imgEffectsOn = Utilities.readImage(Constants.EFFECTS_ON_PATH);
            this.effectsButton.setIcon(imgEffectsOn);
        }
    }
}
