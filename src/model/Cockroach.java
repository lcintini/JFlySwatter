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
        ImageIcon imageIcon1 = Utilities.readImage(Constants.COCKROACH_1_PATH);
        ImageIcon imageIcon2 = Utilities.readImage(Constants.COCKROACH_1_PATH);
        ImageIcon imageIcon3 = Utilities.readImage(Constants.COCKROACH_2_PATH);
        ImageIcon imageIcon4 = Utilities.readImage(Constants.COCKROACH_2_PATH);
        ImageIcon imageIcon5 = Utilities.readImage(Constants.COCKROACH_3_PATH);
        ImageIcon imageIcon6 = Utilities.readImage(Constants.COCKROACH_3_PATH);
        ImageIcon imageIcon7 = Utilities.readImage(Constants.COCKROACH_2_PATH);
        ImageIcon imageIcon8 = Utilities.readImage(Constants.COCKROACH_2_PATH);
        ImageIcon imageIcon9 = Utilities.readImage(Constants.COCKROACH_1_PATH);
        ImageIcon imageIcon10 = Utilities.readImage(Constants.COCKROACH_1_PATH);
        ImageIcon imageIcon11= Utilities.readImage(Constants.COCKROACH_4_PATH);
        ImageIcon imageIcon12= Utilities.readImage(Constants.COCKROACH_4_PATH);
        ImageIcon imageIcon13= Utilities.readImage(Constants.COCKROACH_5_PATH);
        ImageIcon imageIcon14 = Utilities.readImage(Constants.COCKROACH_5_PATH);
        ImageIcon imageIcon15 = Utilities.readImage(Constants.COCKROACH_6_PATH);
        ImageIcon imageIcon16 = Utilities.readImage(Constants.COCKROACH_6_PATH);
        ImageIcon imageIcon17 = Utilities.readImage(Constants.COCKROACH_5_PATH);
        ImageIcon imageIcon18 = Utilities.readImage(Constants.COCKROACH_5_PATH);
        ImageIcon imageIcon19 = Utilities.readImage(Constants.COCKROACH_4_PATH);
        ImageIcon imageIcon20 = Utilities.readImage(Constants.COCKROACH_4_PATH);
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
