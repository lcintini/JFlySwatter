package controller;

import utilities.Utilities;
import view.MenuPanel;

public class MenuController {

    private MainController mainController;
    private int difficulty;
    private boolean musicEnable;
    private boolean effectsEnable;


    public MenuController(MainController mainController, MenuPanel menuPanel) {
        this.mainController = mainController;
        this.difficulty = 1;
        this.musicEnable = true;
        this.effectsEnable = true;
    }

    public void playEffects() {
        if (this.effectsEnable) {
            Utilities.playEffects("slap");
        }
    }
    public void startGame(){
        this.mainController.startGame(this.difficulty, this.effectsEnable, this.musicEnable);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isMusicEnable() {
        return musicEnable;
    }

    public void setMusicEnable(boolean musicEnable) {
        this.musicEnable = musicEnable;
    }

    public boolean isEffectsEnable() {
        return effectsEnable;
    }

    public void setEffectsEnable(boolean effectsEnable) {
        this.effectsEnable = effectsEnable;
    }
}
