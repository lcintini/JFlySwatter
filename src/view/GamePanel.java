package view;

import constants.Constants;
import model.Bug;
import utilities.ImagesList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private ArrayList<Bug> bugs;
    private MainView mainView;

    public GamePanel(MainView mainView) {
        this.mainView = mainView;
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);
        this.setLayout(null);
        Color verde= new Color(117, 201, 231, 255);
        this.setBackground(verde);
        this.bugs = new ArrayList<>();
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me){
                handleClick(me.getX(),me.getY());
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
            Image img = ImagesList.getImage(b.getImg());
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

    public void enterPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.mainView.getMainController().getGameController().pauseGame();
        }
    }

    public void handleClick(int x, int y){
        this.mainView.getMainController().getGameController().handleClick(x,y);
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