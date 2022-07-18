package model;

import constants.Constants;

import javax.swing.*;
import java.util.ArrayList;

public class Ladybug extends Bug{
    public Ladybug(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.LADYBUG_SPEED * (difficulty +1), Constants.LADYBUG_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_LADYBUG;
        this.images = new ArrayList<>();
        ImageIcon imageIcon1 = new ImageIcon("resources/images/ladybug1.png");
        ImageIcon imageIcon2 = new ImageIcon("resources/images/ladybug1.png");
        ImageIcon imageIcon3 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon4 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon5 = new ImageIcon("resources/images/ladybug3.png");
        ImageIcon imageIcon6 = new ImageIcon("resources/images/ladybug3.png");
        ImageIcon imageIcon7 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon8 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon9 = new ImageIcon("resources/images/ladybug1.png");
        ImageIcon imageIcon10 = new ImageIcon("resources/images/ladybug2.png");
        ImageIcon imageIcon11= new ImageIcon("resources/images/ladybug4.png");
        ImageIcon imageIcon12= new ImageIcon("resources/images/ladybug4.png");
        ImageIcon imageIcon13= new ImageIcon("resources/images/ladybug5.png");
        ImageIcon imageIcon14 = new ImageIcon("resources/images/ladybug5.png");
        ImageIcon imageIcon15 = new ImageIcon("resources/images/ladybug4.png");
        ImageIcon imageIcon16 = new ImageIcon("resources/images/ladybug4.png");
        this.images.add(imageIcon1.getImage());
        this.images.add(imageIcon2.getImage());
        this.images.add(imageIcon3.getImage());
        this.images.add(imageIcon4.getImage());
        this.images.add(imageIcon5.getImage());
        this.images.add(imageIcon6.getImage());
        this.images.add(imageIcon7.getImage());
        this.images.add(imageIcon8.getImage());
        this.images.add(imageIcon9.getImage());
        this.images.add(imageIcon10.getImage());
        this.images.add(imageIcon11.getImage());
        this.images.add(imageIcon12.getImage());
        this.images.add(imageIcon13.getImage());
        this.images.add(imageIcon14.getImage());
        this.images.add(imageIcon15.getImage());
        this.images.add(imageIcon16.getImage());
        this.height = Constants.LADYBUG_HEIGHT;
        this.width = Constants.LADYBUG_WIDTH;
    }

    @Override
    public void die() {

    }
}
