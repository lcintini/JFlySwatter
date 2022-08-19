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


    public MenuPanel() {
        Color celeste= new Color(0,170,220);
        this.setBackground(celeste);
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.musicEnable = true;
        this.effectEnable = true;
        this.imgMenu = (Utilities.readImage(Constants.MENU_GRASS_PATH)).getImage();
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
        this.startButton = new JButton("Start Normal Mode");
        this.startButton.setBackground(Color.WHITE);
        this.startButton.setForeground(Color.BLACK);
        this.startButton.setBorder(new LineBorder(Color.BLACK));
        this.startButton.setBounds(100, 200, 440, 80 );
        this.startButton.setFocusPainted(false);
        this.add(this.startButton);
        this.rightArrowButton = new JButton(">");
        this.rightArrowButton.setBackground(Color.WHITE);
        this.rightArrowButton.setForeground(Color.BLACK);
        this.rightArrowButton.setBorder(new LineBorder(Color.BLACK));
        this.rightArrowButton.setBounds(340, 290, 200, 50 );
        this.rightArrowButton.setFocusPainted(false);
        this.add(this.rightArrowButton);
        this.leftArrowButton = new JButton("<");
        this.leftArrowButton.setBackground(Color.WHITE);
        this.leftArrowButton.setForeground(Color.BLACK);
        this.leftArrowButton.setBorder(new LineBorder(Color.BLACK));
        this.leftArrowButton.setBounds(100, 290, 200, 50 );
        this.leftArrowButton.setFocusPainted(false);
        this.add(this.leftArrowButton);
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
