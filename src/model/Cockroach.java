package model;

import constants.Constants;
import utilities.Utilities;

import javax.swing.*;
import java.util.ArrayList;

public class Cockroach extends Bug{
    public Cockroach(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.COCKROACH_SPEED * (difficulty +1), Constants.COCKROACH_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_COCKROACH;
        this.images = new ArrayList<>();
        //1 2 3 2 1 4 5 6 5 4
        ImageIcon imageIcon1 = Utilities.readImage("resources/images/cockroach1.png");
        ImageIcon imageIcon2 = Utilities.readImage("resources/images/cockroach1.png");
        ImageIcon imageIcon3 = Utilities.readImage("resources/images/cockroach2.png");
        ImageIcon imageIcon4 = Utilities.readImage("resources/images/cockroach2.png");
        ImageIcon imageIcon5 = Utilities.readImage("resources/images/cockroach3.png");
        ImageIcon imageIcon6 = Utilities.readImage("resources/images/cockroach3.png");
        ImageIcon imageIcon7 = Utilities.readImage("resources/images/cockroach2.png");
        ImageIcon imageIcon8 = Utilities.readImage("resources/images/cockroach2.png");
        ImageIcon imageIcon9 = Utilities.readImage("resources/images/cockroach1.png");
        ImageIcon imageIcon10 = Utilities.readImage("resources/images/cockroach1.png");
        ImageIcon imageIcon11= Utilities.readImage("resources/images/cockroach4.png");
        ImageIcon imageIcon12= Utilities.readImage("resources/images/cockroach4.png");
        ImageIcon imageIcon13= Utilities.readImage("resources/images/cockroach5.png");
        ImageIcon imageIcon14 = Utilities.readImage("resources/images/cockroach5.png");
        ImageIcon imageIcon15 = Utilities.readImage("resources/images/cockroach6.png");
        ImageIcon imageIcon16 = Utilities.readImage("resources/images/cockroach6.png");
        ImageIcon imageIcon17 = Utilities.readImage("resources/images/cockroach5.png");
        ImageIcon imageIcon18 = Utilities.readImage("resources/images/cockroach5.png");
        ImageIcon imageIcon19 = Utilities.readImage("resources/images/cockroach4.png");
        ImageIcon imageIcon20 = Utilities.readImage("resources/images/cockroach4.png");
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
        this.images.add(imageIcon17.getImage());
        this.images.add(imageIcon18.getImage());
        this.images.add(imageIcon19.getImage());
        this.images.add(imageIcon20.getImage());
        this.height = Constants.COCKROACH_HEIGHT;
        this.width = Constants.COCKROACH_WIDTH;
    }
}
