package model;

import constants.Constants;
import utilities.Utilities;

import javax.swing.*;
import java.util.ArrayList;

public class Butterfly extends Bug {
    private boolean scared;

    public Butterfly(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.BUTTERFLY_SPEED * (difficulty +1), Constants.BUTTERFLY_SPEED * (difficulty +1), direction);
        System.out.println(this.dx);
        this.points = Constants.POINTS_BUTTERFLY;
        this.images = new ArrayList<>();
        ImageIcon imageIcon1 = Utilities.readImage("resources/images/butterfly1.png");
        ImageIcon imageIcon2 = Utilities.readImage("resources/images/butterfly2.png");
        ImageIcon imageIcon3 = Utilities.readImage("resources/images/butterfly3.png");
        ImageIcon imageIcon4 = Utilities.readImage("resources/images/butterfly4.png");
        ImageIcon imageIcon5 = Utilities.readImage("resources/images/butterfly3.png");
        ImageIcon imageIcon6 = Utilities.readImage("resources/images/butterfly2.png");
        this.images.add(imageIcon1.getImage());
        this.images.add(imageIcon2.getImage());
        this.images.add(imageIcon3.getImage());
        this.images.add(imageIcon4.getImage());
        this.images.add(imageIcon5.getImage());
        this.images.add(imageIcon6.getImage());
        this.height = Constants.BUTTERFLY_HEIGHT;
        this.width = Constants.BUTTERFLY_WIDTH;
        this.scared = false;
    }

    @Override
    public void changeDirection(int mouseX, int mouseY) {
        //controlla se un punto è all'interno del cerchio
        boolean checkCircle = Math.pow(this.x - mouseX,2) + Math.pow(this.y - mouseY,2) < Math.pow(100,2);
        if(checkCircle){
            if(!this.scared) {
                this.scared = true;
                //aumenta la velocita appena spaventata
                this.dx *= 4;
                this.dy *= 4;
            }
            this.changeDirButterfly(mouseX, mouseY);
        }
        else{
            if(this.scared) {
                //siamo usciti dal cerchio dello spavento
                this.scared = false;
                this.dx = (int) this.dx/4;
                this.dy = (int) this.dx/4;
            }
            super.changeDirection(mouseX, mouseY);
        }
    }

    //cambia direzione a seconda di dove è il mouse
    private void changeDirButterfly(int mouseX, int mouseY) {
        if(this.x < mouseX && this.y < mouseY){
            this.direction = Direction.NORTHWEST;
        }
        else if( this.x >= mouseX && this.y <= mouseY){
            this.direction = Direction.NORTHEAST;
        }
        else if( this.x >= mouseX && this.y >= mouseY) {
            this.direction = Direction.SOUTHEAST;
        }
        else{
            this.direction = Direction.SOUTHWEST;
        }
    }

}
