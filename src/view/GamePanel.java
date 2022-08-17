package view;

import constants.Constants;
import controller.GameController;
import model.Bug;
import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                enterPressed(e);
            }
        });

    }

    //viene richiamato molte volte al secondo dal thread di java che si occupa della grafica (non da noi) e fa apparire sullo schermo le varie componenti grafiche(come un libricino che sfogli velocemnete)
    //override
    public void paintComponent(Graphics g) {
        //la classe super è il JPanel
        super.paintComponent(g);
        doDrawing(g);
    }
    //gestisce l'animazione degli insetti
    public void doDrawing(Graphics g) {
        this.drawGame(g);
        // Metodo che sincronizza tutte le componenti grafiche
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawGame(Graphics g) {
        for (Bug b:this.bugs) {
            // modo per estrarre una Image prima da una stringa e poi da una ImageIcon
            Image img = (Utilities.readImage(b.getImg())).getImage();
            //momento esatto in cui controlliamo il model
            g.drawImage(img, b.getX(), b.getY(), this);
        }
    }

    public void addBug(Bug bug) {
        this.bugs.add(bug);
    }

    public void removeBug(Bug bug) {
        this.bugs.remove(bug);
    }

    public void removeAllBugs(){
        this.bugs = new ArrayList<>();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
    public void enterPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.gameController.pauseGame();
        }
    }

    public int getMouseLocationX() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int mouseX = (int)(p.getX() - this.getLocationOnScreen().getX());
        return mouseX;
    }

    public int getMouseLocationY() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int mouseY = (int)(p.getY() - this.getLocationOnScreen().getY());
        return mouseY;
    }
}