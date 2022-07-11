package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {  //posso ereditare tutti i metodi della classe JFrame che non sono private
    // JLayeredPane per sovrapporre più pannelli (stratificati)
    private JLayeredPane layeredPane;

    public MainView() throws HeadlessException {
        //creo un oggetto JLayeredPane
        this.layeredPane=new JLayeredPane();
        //inizializzo le caratteristiche del layeredPane
        this.initializeView();
    }

    private void initializeView() {
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
    }

    public void addMenuPanel(MenuPanel mp){
        this.layeredPane.add(mp, JLayeredPane.DEFAULT_LAYER);
        this.layeredPane.setPreferredSize( new Dimension(800,600));
        this.pack();
    }

}
