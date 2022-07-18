package model;

import constants.Constants;

import javax.swing.*;
import java.util.ArrayList;

import static model.Direction.EAST;
import static model.Direction.WEST;

public class Wasp extends Bug{

    public Wasp(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.WASP_SPEED * (difficulty +1), Constants.WASP_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_FLY;
        this.images = new ArrayList<>();
        ImageIcon imageIcon1 = new ImageIcon("resources/images/wasp1.png");
        ImageIcon imageIcon2 = new ImageIcon("resources/images/wasp2.png");
        this.images.add(imageIcon1.getImage());
        this.images.add(imageIcon2.getImage());
        this.height = Constants.WASP_HEIGHT;
        this.width = Constants.WASP_WIDTH;
    }

    @Override
    public void changeDirection(int mouseX, int mouseY) {
        //
    }

    @Override
    public void changeDirectionBorder() {
        if (this.isInBorderX1() && this.direction == WEST) {
            this.direction = EAST;
            this.x -= 5;
            this.y += 7;
            System.out.println("la vespa sta in x1");
        }
        else if (this.isInBorderX2() && this.direction == EAST){
            this.direction = WEST;
            this.x += 5;
            this.y -= 7;
            System.out.println("la vespa sta in x2");
        }
    }

    @Override
    public void die() {

    }
}
