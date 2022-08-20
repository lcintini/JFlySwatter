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
        Color celeste= new Color(0,170,220);
        this.setBackground(celeste);
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.musicEnable = true;
        this.effectEnable = true;
        this.imgMenu = (Utilities.readImage(Constants.MENU_GRASS_PATH)).getImage();
        this.title = new JLabel("JFlySwatter");
        this.title.setBounds(158, 80, 400, 70);
        this.title.setFont(new Font ("The Bomb", Font.BOLD, 30) );
        this.title.setForeground(Color.WHITE);
        this.add(this.title);
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
        ImageIcon imgRightArrow = Utilities.readImage(Constants.RIGHT_ARROW_PATH);
        this.rightArrowButton = new JButton("");
        this.rightArrowButton.setIcon(imgRightArrow);
        this.rightArrowButton.setBorder(null);
        this.rightArrowButton.setMargin(new Insets(0,0,0,0));
        this.rightArrowButton.setContentAreaFilled(false);
        this.rightArrowButton.setBounds(400, 290, 80, 50 );
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
