package model;

import constants.Constants;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import static model.Direction.*;

public class Fly extends Bug{

    public Fly(int x, int y, Direction direction) {
        super(x, y, direction);
        this.points = Constants.POINTS_FLY;
        this.images = new ArrayList<>();
        ImageIcon imageIcon1 = new ImageIcon("resources/images/fly1.png");
        ImageIcon imageIcon2 = new ImageIcon("resources/images/fly2.png");
        ImageIcon imageIcon3 = new ImageIcon("resources/images/fly1.png");
        ImageIcon imageIcon4 = new ImageIcon("resources/images/fly3.png");
        ImageIcon imageIcon5 = new ImageIcon("resources/images/fly1.png");
        ImageIcon imageIcon6 = new ImageIcon("resources/images/fly2.png");
        this.images.add(imageIcon1.getImage());
        this.images.add(imageIcon2.getImage());
        this.images.add(imageIcon3.getImage());
        this.images.add(imageIcon4.getImage());
        this.images.add(imageIcon5.getImage());
        this.images.add(imageIcon6.getImage());
        this.dx = 1;
        this.dy = 1;
        this.height = Constants.FLY_HEIGHT;
        this.width = Constants.FLY_WIDTH;
    }

   public void changeDirection(){
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
   public void die(){

   }

}
