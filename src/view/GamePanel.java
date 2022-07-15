package view;

import constants.Constants;
import controller.GameController;
import model.Bug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private ArrayList<Bug> bugs;
    private GameController gameController;

    public GamePanel() {
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        this.bugs = new ArrayList<>();
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                gameController.handleClick(me.getX(),me.getY());
            }
        });

    }

    //viene richiamato molte volte al secondo dal thread di java che si occupa della grafica (non da noi) e fa apparire sullo schermo le varie componenti grafiche(come un libricino che sfogli velocemnete)
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
        synchronized (this.bugs){
            for (Bug b:this.bugs) {
                //momento esatto in cui controlliamo il model
                g.drawImage(b.getImg(), b.getX(), b.getY(), this);
            }
        }
    }

    public void addBug(Bug bug) {
        synchronized (this.bugs){
            this.bugs.add(bug);
        }
    }
    public void removeBug(Bug bug) {
        synchronized (this.bugs){
            this.bugs.remove(bug);
        };
    }

    public void removeAllBugs(){
        synchronized (this.bugs){
            this.bugs = new ArrayList<>();
        }
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}