package model;

import constants.Constants;
import utilities.Direction;
import java.util.ArrayList;

public class Cockroach extends Bug{
    public Cockroach(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.COCKROACH_SPEED * (difficulty +1), Constants.COCKROACH_SPEED * (difficulty +1), direction);
        this.points = Constants.POINTS_COCKROACH;
        this.images = new ArrayList<>();
        String imageString1 = Constants.COCKROACH_1_PATH;
        String imageString2 = Constants.COCKROACH_2_PATH;
        String imageString3 = Constants.COCKROACH_3_PATH;
        String imageString4 = Constants.COCKROACH_2_PATH;
        String imageString5 = Constants.COCKROACH_1_PATH;
        String imageString6 = Constants.COCKROACH_4_PATH;
        String imageString7 = Constants.COCKROACH_5_PATH;
        String imageString8 = Constants.COCKROACH_6_PATH;
        String imageString9 = Constants.COCKROACH_5_PATH;
        String imageString10 = Constants.COCKROACH_4_PATH;
        this.images.add(imageString1);
        this.images.add(imageString2);
        this.images.add(imageString3);
        this.images.add(imageString4);
        this.images.add(imageString5);
        this.images.add(imageString6);
        this.images.add(imageString7);
        this.images.add(imageString8);
        this.images.add(imageString9);
        this.images.add(imageString10);
        this.height = Constants.COCKROACH_HEIGHT;
        this.width = Constants.COCKROACH_WIDTH;
    }
}
