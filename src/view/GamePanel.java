package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
    }

    //viene richiamato molte volte al secondo dal thread di java che si occupa della grafica non da noi e fa apparire sullo schermo le varie componenti grafiche(come un libricino che sfogli velocemnete)
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //override
        doDrawing();
    }

    public void doDrawing() {
        // Creiamo il menù
        this.drawGame();
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawGame() {
    }
}