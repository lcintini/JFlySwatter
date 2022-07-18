package model;

import constants.Constants;

import javax.swing.*;
import java.util.ArrayList;

public class Cockroach extends Bug{
    public Cockroach(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.COCKROACH_SPEED * (difficulty +1), Constants.COCKROACH_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_COCKROACH;
        this.images = new ArrayList<>();
        //1 2 3 2 1 4 5 6 5 4
        ImageIcon imageIcon1 = new ImageIcon("resources/images/cockroach1.png");
        ImageIcon imageIcon2 = new ImageIcon("resources/images/cockroach2.png");
        /*ImageIcon imageIcon2 = new ImageIcon("resources/images/cockroach1.png");
        ImageIcon imageIcon4 = new ImageIcon("resources/images/cockroach1.png");
        ImageIcon imageIcon5 = new ImageIcon("resources/images/cockroach1.png");
        ImageIcon imageIcon6 = new ImageIcon("resources/images/cockroach1.png");
        ImageIcon imageIcon7 = new ImageIcon("resources/images/cockroach1.png");
        ImageIcon imageIcon8 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon9 = new ImageIcon("resources/images/ladybug1.png");
        ImageIcon imageIcon10 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon11= new ImageIcon("resources/images/ladybug4.png");
        ImageIcon imageIcon12= new ImageIcon("resources/images/ladybug4.png");
        ImageIcon imageIcon13= new ImageIcon("resources/images/ladybug5.png");
        ImageIcon imageIcon14 = new ImageIcon("resources/images/ladybug5.png");
        ImageIcon imageIcon15 = new ImageIcon("resources/images/ladybug4.png");
        ImageIcon imageIcon16 = new ImageIcon("resources/images/ladybug4.png");
         */
        this.images.add(imageIcon1.getImage());
        this.images.add(imageIcon2.getImage());
        this.height = Constants.COCKROACH_HEIGHT;
        this.width = Constants.COCKROACH_WIDTH;
    }

    @Override
    public void die() {

    }
}
