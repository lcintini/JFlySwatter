package model;

public class GameModel {
    private int count;
    private int difficulty;
    private int level;
    private int timerLeft;
    private long startTime;
    private boolean musicEnable;
    private boolean effectsEnable;
    private int highScore;

    public GameModel(int difficulty, int level, boolean musicEnable, boolean effectsEnable) {
        this.difficulty = difficulty;
        this.level = level;
        this.musicEnable = musicEnable;
        this.effectsEnable = effectsEnable;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTimerLeft() {
        return timerLeft;
    }

    public void setTimerLeft(int timerLeft) {
        this.timerLeft = timerLeft;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
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

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
