package view;

import constants.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton startButton;
    private JButton rightArrowButton;
    private JButton leftArrowButton;
    private JButton musicButton;
    private JButton effectsButton;



    public MenuPanel() {
        Color celeste= new Color(0,170,220);
        this.setBackground(celeste);
        this.setBounds(0,0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.drawMenu();
    }

    private void drawMenu() {
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
        this.musicButton = new JButton("Music ON/OFF");
        this.musicButton.setBackground(Color.WHITE);
        this.musicButton.setForeground(Color.BLACK);
        this.musicButton.setBorder(new LineBorder(Color.BLACK));
        this.musicButton.setBounds(100, 350, 200, 50 );
        this.musicButton.setFocusPainted(false);
        this.add(this.musicButton);
        this.effectsButton = new JButton("Effects ON/OFF");
        this.effectsButton.setBackground(Color.WHITE);
        this.effectsButton.setForeground(Color.BLACK);
        this.effectsButton.setBorder(new LineBorder(Color.BLACK));
        this.effectsButton.setBounds(340, 350, 200, 50 );
        this.effectsButton.setFocusPainted(false);
        this.add(this.effectsButton);
    }

    public JButton getStartButton() {
        return this.startButton;
    }
}
