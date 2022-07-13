package view;

import constants.Constants;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    private JButton startButton;

    public MenuPanel() {
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
    }

    public JButton getStartButton() {
        return this.startButton;
    }
}
