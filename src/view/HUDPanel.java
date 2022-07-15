package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {
    private Image imgHUD;
    private JLabel count;
    private JLabel timer;

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
}
