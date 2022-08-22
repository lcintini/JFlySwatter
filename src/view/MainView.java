package view;

import constants.Constants;
import controller.GameController;
import controller.MainController;
import controller.MenuController;
import utilities.ImagesList;
import utilities.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {  //posso ereditare tutti i metodi della classe JFrame che non sono private
    //gestisce la sovrapposizione di pannelli
    private JLayeredPane layeredPane;
    private Swatter swatter;
    private MenuPanel menuPanel;
    private GamePanel gamePanel;

    private HUDPanel hudPanel;
    private PausePanel pausePanel;
    private MainController mainController;

    public MainView(MainController mainController){
        this.mainController = mainController;
        this.layeredPane=new JLayeredPane();
        this.swatter = new Swatter();
        ImagesList.preloadImages();
        this.initializeView();
        //posiziona il frame al centro dello schermo
        Dimension screenSize = Toolkit.getDefaultToolkit ( ).getScreenSize ( );
        this.setLocation ( ( screenSize.width / 2 ) - ( Constants.BOARD_WIDTH/ 2 ), (
                screenSize.height / 2 ) - ( Constants.BOARD_HEIGHT/ 2 ) );
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
                this.swatter.getImg(),
                new Point(0,0),"custom cursor"));
        this.pack();
    }

    public void addMenuPanel(MenuPanel mp, MenuController menuController){
        this.menuPanel = mp;
        ImageIcon imgStartNormal = (Utilities.readImage(Constants.START_NORMAL_BUTTON_PATH));
        ImageIcon imgStartEasy = (Utilities.readImage(Constants.START_EASY_BUTTON_PATH));
        ImageIcon imgStartHard = (Utilities.readImage(Constants.START_HARD_BUTTON_PATH));
        ImageIcon imgMusicOn = (Utilities.readImage(Constants.MUSIC_ON_PATH));
        ImageIcon imgMusicOff = (Utilities.readImage(Constants.MUSIC_OFF_PATH));
        ImageIcon imgEffectsOn = (Utilities.readImage(Constants.EFFECTS_ON_PATH));
        ImageIcon imgEffectsOff = (Utilities.readImage(Constants.EFFECTS_OFF_PATH));
        JButton startButton= mp.getStartButton();
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.playEffects();
                menuController.startGame();
            }
        });
        JButton rightArrowButton= mp.getRightArrowButton();
        rightArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.playEffects();
                menuController.setDifficulty((Math.floorMod(menuController.getDifficulty() + 1, 3) + Math.abs(3)) % Math.abs(3)); //modulo per gestire il livello circolarmente
                if (menuController.getDifficulty() == 0) {
                    //startButton.setText("Start Easy Mode");
                    startButton.setIcon(imgStartEasy);
                } else if (menuController.getDifficulty() == 1) {
                    //startButton.setText("Start Normal Mode");
                    startButton.setIcon(imgStartNormal);
                } else {
                    //startButton.setText("Start Hard Mode");
                    startButton.setIcon(imgStartHard);
                    //startButton.setText("Start "+ difficulties[menuController.getDifficulty()] + " Mode");
                }
            }
        });
        JButton leftArrowButton= mp.getLeftArrowButton();
        leftArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                    menuController.playEffects();
                    menuController.setDifficulty((Math.floorMod(menuController.getDifficulty() - 1, 3) + Math.abs(3)) % Math.abs(3)); //modulo per gestire il livello circolarmente
                    if (menuController.getDifficulty() == 0) {
                        //startButton.setText("Start Easy Mode");
                        startButton.setIcon(imgStartEasy);
                    } else if (menuController.getDifficulty() == 1) {
                        //startButton.setText("Start Normal Mode");
                        startButton.setIcon(imgStartNormal);
                    } else {
                        startButton.setIcon(imgStartHard);
                        //startButton.setText("Start Hard Mode");
                        //startButton.setText("Start "+ difficulties[menuController.getDifficulty()] + " Mode");
                    }
                }
        });
        JButton musicButton= mp.getMusicButton();
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.playEffects();
                menuController.setMusicEnable(!menuController.isMusicEnable());
                if (!menuController.isMusicEnable()) {
                    musicButton.setIcon(imgMusicOn);
                } else {
                    musicButton.setIcon(imgMusicOff);
                }
                //mp.setMusicEnable(menuController.isMusicEnable());
            }
        });
        JButton effectsButton= mp.getEffectsButton();
        effectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.setEffectsEnable(!menuController.isEffectsEnable());
                menuController.playEffects();
                if (!menuController.isEffectsEnable()) {
                    effectsButton.setIcon(imgEffectsOn);
                } else {
                    effectsButton.setIcon(imgEffectsOff);
                }
                //mp.setEffectEnable(menuController.isEffectsEnable());
            }
        });
        //quando aggiungo il pannello del menu, prima devo togliere tutti i pannelli precedentemente inseriti
        this.layeredPane.removeAll();
        this.layeredPane.add(mp, JLayeredPane.DEFAULT_LAYER);
        this.layeredPane.setPreferredSize( new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.pack();
    }

    public void addGamePanel(GamePanel gp, HUDPanel hp){
        this.gamePanel = gp;
        this.hudPanel = hp;
        this.layeredPane.removeAll();
        this.layeredPane.add(gp, JLayeredPane.DEFAULT_LAYER);
        hp.setOpaque(false);
        this.layeredPane.add(hp, JLayeredPane.PALETTE_LAYER);
        this.layeredPane.setPreferredSize( new Dimension(Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT));
        this.pack();
    }
    public void addPausePanel(PausePanel pp, GameController gameController) {
        ImageIcon imgMusicOn = (Utilities.readImage(Constants.MUSIC_ON_PATH));
        ImageIcon imgMusicOff = (Utilities.readImage(Constants.MUSIC_OFF_PATH));
        ImageIcon imgEffectsOn = (Utilities.readImage(Constants.EFFECTS_ON_PATH));
        ImageIcon imgEffectsOff = (Utilities.readImage(Constants.EFFECTS_OFF_PATH));
        this.pausePanel = pp;
        JButton resumeButton= pp.getResumeButton();
        resumeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.playEffects("slap");
                gameController.resumeGame();
            }
        });
        JButton exitButton= pp.getExitButton();
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.playEffects("slap");
                gameController.exitGame();
            }
        });
        JButton musicButton= pp.getMusicButton();
        musicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.playEffects("slap");
                gameController.setMusicEnable(!gameController.isMusicEnable());
                if (!gameController.isMusicEnable()) {
                    musicButton.setIcon(imgMusicOn);
                } else {
                    musicButton.setIcon(imgMusicOff);
                }
                //pp.setMusicEnable(gameController.isMusicEnable());
            }
        });
        JButton effectsButton= pp.getEffectsButton();
        effectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.setEffectsEnable(!gameController.isEffectsEnable());
                gameController.playEffects("slap");
                if (!gameController.isEffectsEnable()) {
                    effectsButton.setIcon(imgEffectsOn);
                } else {
                    effectsButton.setIcon(imgEffectsOff);
                }
                //pp.setEffectEnable(gameController.isEffectsEnable());
            }
        });
        this.layeredPane.add(pp, JLayeredPane.MODAL_LAYER);
        this.pack();
    }

    public void removePausePanel(){
        this.layeredPane.remove(this.pausePanel);
        this.pack();
    }
    public void nextCursor(){
        this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                this.swatter.getImg(),
                new Point(0,0),"custom cursor"));
        this.pack();
    }

    public void setNormalSwatter(){
        this.swatter.setNormalAnimation(true);
    }

    public void setSwatSwatter(){
        this.swatter.setSwatAnimation(true);
    }

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    public HUDPanel getHudPanel() {
        return this.hudPanel;
    }

    public MainController getMainController(){
        return this.mainController;
    }
}
