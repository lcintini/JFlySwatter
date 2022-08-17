package model;

import constants.Constants;
import utilities.Direction;
import utilities.Utilities;

import javax.swing.*;
import java.util.ArrayList;

public class Ladybug extends Bug{
    public Ladybug(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.LADYBUG_SPEED * (difficulty +1), Constants.LADYBUG_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_LADYBUG;
        this.images = new ArrayList<>();
        String imageString1 = Constants.LADYBUG_1_PATH;
        String imageString2 = Constants.LADYBUG_2_PATH;
        String imageString3 = Constants.LADYBUG_3_PATH;
        String imageString4 = Constants.LADYBUG_2_PATH;
        String imageString5 = Constants.LADYBUG_1_PATH;
        String imageString6 = Constants.LADYBUG_2_PATH;
        String imageString7 = Constants.LADYBUG_4_PATH;
        String imageString8 = Constants.LADYBUG_5_PATH;
        String imageString9 = Constants.LADYBUG_4_PATH;
        this.images.add(imageString1);
        this.images.add(imageString2);
        this.images.add(imageString3);
        this.images.add(imageString4);
        this.images.add(imageString5);
        this.images.add(imageString6);
        this.images.add(imageString7);
        this.images.add(imageString8);
        this.images.add(imageString9);
        this.height = Constants.LADYBUG_HEIGHT;
        this.width = Constants.LADYBUG_WIDTH;
    }
}
