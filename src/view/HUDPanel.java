package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

public class HUDPanel extends JPanel {
    private Image imgHUD;
    public HUDPanel() {
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.imgHUD = (new ImageIcon("resources/images/hud-flyswatter.png")).getImage();
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



}
