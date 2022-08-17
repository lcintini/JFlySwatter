package model;

import constants.Constants;
import utilities.Direction;
import utilities.Utilities;

import javax.swing.*;
import java.util.ArrayList;

public class Fly extends Bug{

    public Fly(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.FLY_SPEED * (difficulty +1), Constants.FLY_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_FLY;
        this.images = new ArrayList<>();
        String imageString1 = Constants.FLY_1_PATH;
        String imageString2 = Constants.FLY_2_PATH;
        String imageString3 = Constants.FLY_1_PATH;
        String imageString4 = Constants.FLY_3_PATH;
        String imageString5 = Constants.FLY_1_PATH;
        String imageString6 = Constants.FLY_2_PATH;
        this.images.add(imageString1);
        this.images.add(imageString2);
        this.images.add(imageString3);
        this.images.add(imageString4);
        this.images.add(imageString5);
        this.images.add(imageString6);
        this.height = Constants.FLY_HEIGHT;
        this.width = Constants.FLY_WIDTH;
    }
}
