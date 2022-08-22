package view;

import constants.Constants;
import utilities.Utilities;
import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {
    private Image imgHUD;
    private JLabel count;
    private JLabel timer;
    private JLabel gameOver;
    private JLabel victory;
    private JLabel highScore;
    private JLabel level;

    public HUDPanel() {
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.imgHUD = (Utilities.readImage(Constants.HUD_FLY_SWATTER_PATH)).getImage();
        this.count = new JLabel();
        this.count.setBounds(30, 370, 200, 50);
        this.count.setFont(new Font ("The Bomb", Font.BOLD, 13) );
        this.count.setForeground(Color.BLACK);
        this.add(this.count);
        this.timer = new JLabel();
        this.timer.setBounds(511, 370, 200, 50);
        this.timer.setFont(new Font ("The Bomb", Font.BOLD, 13) );
        this.timer.setForeground(Color.BLACK);
        this.add(this.timer);
        this.gameOver = new JLabel("GAME OVER");
        this.gameOver.setBounds(225, 420, 200, 50);
        this.gameOver.setVisible(false);
        this.gameOver.setForeground(Color.RED);
        this.gameOver.setFont(new Font ("The Bomb", Font.BOLD, 20) );
        this.add(this.gameOver);
        this.victory = new JLabel("YOU WIN");
        this.victory.setBounds(240, 420, 200, 50);
        this.victory.setVisible(false);
        this.victory.setForeground(Color.GREEN);
        this.victory.setFont(new Font ("The Bomb", Font.BOLD, 20) );
        this.add(this.victory);
        this.level = new JLabel("Level: "+ level);
        this.level.setBounds(300, -10, 200, 50);
        this.level.setFont(new Font ("The Bomb", Font.BOLD, 10) );
        this.level.setForeground(Color.BLACK);
        this.add(this.level);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //override
        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        this.drawHUD(g);
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawHUD(Graphics g) {
        g.drawImage(this.imgHUD,0,0,this);
    }

    public void changeCount(String s) {
        this.count.setText(s);
    }

    public void changeTimer(String s) {
        this.timer.setText(s);
    }

    public void changeLevel(String s) {
        this.level.setText(s);
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

    public void printHighScore(int highScore){
        this.highScore = new JLabel("Highscore: "+ highScore);
        this.highScore.setBounds(258, 370, 200, 50);
        this.highScore.setFont(new Font ("The Bomb", Font.BOLD, 13) );
        this.highScore.setForeground(Color.BLACK);
        this.add(this.highScore);
    }
}
