package model;

import constants.Constants;
import utilities.Direction;
import java.util.ArrayList;

public class Butterfly extends Bug {
    private boolean scared;

    public Butterfly(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.BUTTERFLY_SPEED * (difficulty +1), Constants.BUTTERFLY_SPEED * (difficulty +1), direction);
        System.out.println(this.dx);
        this.points = Constants.POINTS_BUTTERFLY;
        this.images = new ArrayList<>();
        String imageString1 = Constants.BUTTERFLY_1_PATH;
        String imageString2 = Constants.BUTTERFLY_2_PATH;
        String imageString3 = Constants.BUTTERFLY_3_PATH;
        String imageString4 = Constants.BUTTERFLY_4_PATH;
        String imageString5 = Constants.BUTTERFLY_3_PATH;
        String imageString6 = Constants.BUTTERFLY_2_PATH;
        this.images.add(imageString1);
        this.images.add(imageString2);
        this.images.add(imageString3);
        this.images.add(imageString4);
        this.images.add(imageString5);
        this.images.add(imageString6);
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
    public void changeDirButterfly(int mouseX, int mouseY) {
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
