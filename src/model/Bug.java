package model;

import constants.Constants;

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

    public void move(){
        int speed = this.dx;

        switch(this.direction){
            case NORTH:
                y -= speed;
                break;
            case SOUTH:
                y += speed;
                break;
            case WEST:
                x -= speed;
                break;
            case EAST:
                x += speed;
                break;
            case NORTHEAST:
                y-= speed;
                x+= speed;
                break;
            case NORTHWEST:
                y-= speed;
                x-= speed;
                break;
            case SOUTHEAST:
                y+= speed;
                x+= speed;
                break;
            case SOUTHWEST:
                y+= speed;
                x-= speed;
                break;
        }
        if(this.isInBorderX1() || this.isInBorderX2() || this.isInBorderY1() || this.isInBorderY2()){
            this.changeDirectionBorder();
        } else {
            this.changeDirection();
        }
    }

    public abstract void changeDirectionBorder();

    public abstract void changeDirection();

    public boolean isInBorderX1(){
        return (x>0 && x <= Constants.BORDER_X1);
    }

    public boolean isInBorderX2(){
        return (x+Constants.BORDER_X1>= Constants.BORDER_X2 && x<= Constants.BOARD_WIDTH);
    }

    public boolean isInBorderY1(){
        return (y>0 && y <= Constants.BORDER_Y1);
    }
    public boolean isInBorderY2(){
        return (y+Constants.BORDER_X1>= Constants.BORDER_Y2 && y<= Constants.BOARD_HEIGHT);
    }
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
