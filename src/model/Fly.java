package model;

import constants.Constants;

import javax.swing.*;
import java.util.ArrayList;

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
        this.dx = 2;
        this.dy = 2;
    }

    @Override
    public void move() {
        this.x += this.dx;
        this.y += this.dy;

    }
}
