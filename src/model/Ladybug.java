package model;

import constants.Constants;
import utilities.Utilities;

import javax.swing.*;
import java.util.ArrayList;

public class Ladybug extends Bug{
    public Ladybug(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.LADYBUG_SPEED * (difficulty +1), Constants.LADYBUG_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_LADYBUG;
        this.images = new ArrayList<>();
        ImageIcon imageIcon1 = Utilities.readImage(Constants.LADYBUG_1_PATH);
        ImageIcon imageIcon2 = Utilities.readImage(Constants.LADYBUG_1_PATH);
        ImageIcon imageIcon3 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        ImageIcon imageIcon4 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        ImageIcon imageIcon5 = Utilities.readImage(Constants.LADYBUG_3_PATH);
        ImageIcon imageIcon6 = Utilities.readImage(Constants.LADYBUG_3_PATH);
        ImageIcon imageIcon7 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        ImageIcon imageIcon8 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        ImageIcon imageIcon9 = Utilities.readImage(Constants.LADYBUG_1_PATH);
        ImageIcon imageIcon10 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        ImageIcon imageIcon11 = Utilities.readImage(Constants.LADYBUG_4_PATH);
        ImageIcon imageIcon12 = Utilities.readImage(Constants.LADYBUG_4_PATH);
        ImageIcon imageIcon13 = Utilities.readImage(Constants.LADYBUG_5_PATH);
        ImageIcon imageIcon14 = Utilities.readImage(Constants.LADYBUG_5_PATH);
        ImageIcon imageIcon15 = Utilities.readImage(Constants.LADYBUG_4_PATH);
        ImageIcon imageIcon16 = Utilities.readImage(Constants.LADYBUG_4_PATH);
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
}
