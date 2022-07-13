package view;

import constants.Constants;
import model.Bug;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Bug simpleBug;

    public GamePanel() {
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
    }

    //viene richiamato molte volte al secondo dal thread di java che si occupa della grafica non da noi e fa apparire sullo schermo le varie componenti grafiche(come un libricino che sfogli velocemnete)
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //override
        doDrawing(g);
    }

    public void doDrawing(Graphics g) {
        // Creiamo il menù
        this.drawGame(g);
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawGame(Graphics g) {
        if(this.simpleBug != null){
            g.drawImage(this.simpleBug.getImg(), this.simpleBug.getX(), this.simpleBug.getY(), this);
        }
    }

    public void addBug(Bug bug) {
        this.simpleBug = bug;
    }
}