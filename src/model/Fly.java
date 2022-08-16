package model;

import constants.Constants;
import utilities.Utilities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import static model.Direction.*;

public class Fly extends Bug{

    public Fly(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.FLY_SPEED * (difficulty +1), Constants.FLY_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_FLY;
        this.images = new ArrayList<>();
        ImageIcon imageIcon1 = Utilities.readImage(Constants.FLY_1_PATH);
        ImageIcon imageIcon2 = Utilities.readImage(Constants.FLY_2_PATH);
        ImageIcon imageIcon3 = Utilities.readImage(Constants.FLY_1_PATH);
        ImageIcon imageIcon4 = Utilities.readImage(Constants.FLY_3_PATH);
        ImageIcon imageIcon5 = Utilities.readImage(Constants.FLY_1_PATH);
        ImageIcon imageIcon6 = Utilities.readImage(Constants.FLY_2_PATH);
        this.images.add(imageIcon1.getImage());
        this.images.add(imageIcon2.getImage());
        this.images.add(imageIcon3.getImage());
        this.images.add(imageIcon4.getImage());
        this.images.add(imageIcon5.getImage());
        this.images.add(imageIcon6.getImage());
        this.height = Constants.FLY_HEIGHT;
        this.width = Constants.FLY_WIDTH;
    }
}
