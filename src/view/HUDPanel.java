package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {
    private Image imgHUD;
    private JLabel count;
    private JLabel timer;
    private JLabel gameOver;
    private JLabel victory;

    public HUDPanel() {
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.imgHUD = (new ImageIcon("resources/images/hud-flyswatter.png")).getImage();
        this.count = new JLabel();
        this.count.setBounds(30, 370, 200, 50);
        this.add(this.count);
        this.timer = new JLabel();
        this.timer.setBounds(550, 370, 200, 50);
        this.add(this.timer);
        this.gameOver = new JLabel("GAME OVER");
        this.gameOver.setBounds(300, 370, 200, 50);
        this.gameOver.setVisible(false);
        this.gameOver.setForeground(Color.RED);
        this.add(this.gameOver);
        this.victory = new JLabel("YOU WIN");
        this.victory.setBounds(300, 370, 200, 50);
        this.victory.setVisible(false);
        this.victory.setForeground(Color.GREEN);
        this.add(this.victory);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //override
        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        // Creiamo il menù
        this.drawHUD(g);
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawHUD(Graphics g) {
        g.drawImage(this.imgHUD,0,0,this);

    }

    public JLabel getCount() {
        return count;
    }
    public JLabel getTimer() {
        return timer;
    }

    public void printGameOver() {
        this.gameOver.setVisible(true);
        this.gameOver.paintImmediately(this.gameOver.getVisibleRect());
    }
    public void hideGameOver() {
        this.gameOver.setVisible(false);
        this.gameOver.paintImmediately(this.gameOver.getVisibleRect());
    }
    public void printVictory() {
        this.victory.setVisible(true);
        this.victory.paintImmediately(this.victory.getVisibleRect());
    }

    public void hideVictory() {
        this.victory.setVisible(false);
        this.victory.paintImmediately(this.victory.getVisibleRect());
    }


}
