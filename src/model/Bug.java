package model;

import java.awt.*;
import java.util.ArrayList;

public abstract class Bug {
    protected ArrayList<Image> images;
    protected double imgIndex;
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int points;
    protected Direction direction;

    public Bug(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.imgIndex = 1;
    }

    public abstract void move();

    public Image getImg() {
        imgIndex+=0.5;
        if(imgIndex >= images.size()){
            imgIndex = 1;
        }
        return images.get(((int) Math.floor(imgIndex))-1);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public int getPoints() {
        return points;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
