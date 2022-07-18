package model;

import constants.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static model.Direction.*;
import static model.Direction.NORTH;

public abstract class Bug {
    protected ArrayList<Image> images;
    protected double imgIndex;
    protected int x;
    protected int y;
    protected int dx;
    protected int dy;
    protected int points;
    protected Direction direction;

    protected int height;
    protected int width;

    public Bug(int x, int y, int dx, int dy, Direction direction) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.direction = direction;
        this.imgIndex = 1;
    }

    public void move(int mouseX, int mouseY){
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
            this.changeDirection(mouseX, mouseY);
        }
    }
    public void changeDirection(int mouseX, int mouseY){
        Direction[] nextDir = new Direction[3];

        switch(this.direction){
            case NORTH:
                nextDir= new Direction[]{NORTH, NORTHEAST, NORTHWEST};
                break;
            case SOUTH:
                nextDir= new Direction[]{SOUTH, SOUTHEAST, SOUTHWEST};
                break;
            case WEST:
                nextDir= new Direction[]{WEST, NORTHWEST, SOUTHWEST};
                break;
            case EAST:
                nextDir= new Direction[]{EAST, NORTHEAST, SOUTHEAST};
                break;
            case NORTHEAST:
                nextDir= new Direction[]{NORTHEAST, NORTH, EAST};
                break;
            case NORTHWEST:
                nextDir= new Direction[]{NORTHWEST, NORTH, WEST};
                break;
            case SOUTHEAST:
                nextDir= new Direction[]{SOUTHEAST, SOUTH, EAST};
                break;
            case SOUTHWEST:
                nextDir= new Direction[]{SOUTHWEST, SOUTH, WEST};
                break;
        }
        Random r=new Random();
        int randomNumber=r.nextInt(nextDir.length);
        this.direction = nextDir[randomNumber];

    }
    public void changeDirectionBorder(){
        if(this.isInBorderX1()){
            if(this.isInBorderY1()){
                this.direction = SOUTHEAST;
            } else {
                this.direction = EAST;
            }
        } else if(this.isInBorderX2()) {
            if(this.isInBorderY2()){
                this.direction = NORTHWEST;
            } else {
                this.direction = WEST;
            }
        } else if(this.isInBorderY1()){
            if(this.isInBorderX2()){
                this.direction = SOUTHWEST;
            } else {
                this.direction = SOUTH;
            }
        } else if(this.isInBorderY2()){
            if(this.isInBorderX1()){
                this.direction = NORTHEAST;
            } else {
                this.direction = NORTH;
            }
        }
    }
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
        imgIndex+=0.25;
        if(imgIndex >= images.size()){
            imgIndex = 1;
        }
        return images.get(((int) Math.floor(imgIndex))-1);
    }
    public abstract void die();

    public boolean isClicked(int x, int y){
        return (x>=this.x && x<=this.x+this.width && y>=this.y && y<=this.y+this.height);

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
