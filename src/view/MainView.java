package view;

import constants.Constants;
import model.Swatter;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {  //posso ereditare tutti i metodi della classe JFrame che non sono private
    //gestisce la sovrapposizione di pannelli
    private JLayeredPane layeredPane;

    public MainView() throws HeadlessException {
        this.layeredPane=new JLayeredPane();
        Swatter.createSwatter();
        this.initializeView();
    }

    // la finestra
    public void initializeView() {
        //inserisco nel JFrame un nuovo elemento di tipo JPanel
        this.setContentPane(this.layeredPane);
        this.setVisible(true);
        this.setTitle("JFlySwatter");

        //impacchetta tutto
        this.pack();

        //cliccata la x, interrompe anche il processo
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //posiziona la finestra al centro dello schermo
        this.setLocationRelativeTo(null);
        //non posso ridimenzionarla
        this.setResizable(false);
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                Swatter.getImg(),
                new Point(0,0),"custom cursor"));
        this.pack();
    }

    public void addMenuPanel(MenuPanel mp){
        //quando aggiungo il pannello del menu, prima devo togliere tutti i pannelli precedentemente inseriti
        this.layeredPane.removeAll();
        this.layeredPane.add(mp, JLayeredPane.DEFAULT_LAYER);
        this.layeredPane.setPreferredSize( new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.pack();
    }

    public void addGamePanel(GamePanel gp, HUDPanel hp){
        this.layeredPane.removeAll();
        this.layeredPane.add(gp, JLayeredPane.DEFAULT_LAYER);
        hp.setOpaque(false);
        this.layeredPane.add(hp, JLayeredPane.PALETTE_LAYER);
        this.layeredPane.setPreferredSize( new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.pack();
    }


    public void addPausePanel(PausePanel pausePanel) {
        this.layeredPane.add(pausePanel, JLayeredPane.MODAL_LAYER);
        this.pack();
    }
    public void removePausePanel(PausePanel pausePanel){
        this.layeredPane.remove(pausePanel);
        this.pack();
    }
    public void nextCursor(){
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                Swatter.getImg(),
                new Point(0,0),"custom cursor"));
        this.pack();
    }
}
