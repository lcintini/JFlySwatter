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
        String imageString2 = Constants.COCKROACH_1_PATH;
        String imageString3 = Constants.COCKROACH_1_PATH;
        String imageString4 = Constants.COCKROACH_2_PATH;
        String imageString5 = Constants.COCKROACH_2_PATH;
        String imageString6 = Constants.COCKROACH_2_PATH;
        String imageString7 = Constants.COCKROACH_3_PATH;
        String imageString8 = Constants.COCKROACH_3_PATH;
        String imageString9 = Constants.COCKROACH_3_PATH;
        String imageString10 = Constants.COCKROACH_2_PATH;
        String imageString11 = Constants.COCKROACH_2_PATH;
        String imageString12 = Constants.COCKROACH_2_PATH;
        String imageString13 = Constants.COCKROACH_1_PATH;
        String imageString14 = Constants.COCKROACH_1_PATH;
        String imageString15 = Constants.COCKROACH_1_PATH;
        String imageString16 = Constants.COCKROACH_4_PATH;
        String imageString17 = Constants.COCKROACH_4_PATH;
        String imageString18 = Constants.COCKROACH_4_PATH;
        String imageString19 = Constants.COCKROACH_5_PATH;
        String imageString20 = Constants.COCKROACH_5_PATH;
        String imageString21 = Constants.COCKROACH_5_PATH;
        String imageString22 = Constants.COCKROACH_6_PATH;
        String imageString23 = Constants.COCKROACH_6_PATH;
        String imageString24 = Constants.COCKROACH_6_PATH;
        String imageString25 = Constants.COCKROACH_5_PATH;
        String imageString26 = Constants.COCKROACH_5_PATH;
        String imageString27 = Constants.COCKROACH_5_PATH;
        String imageString28 = Constants.COCKROACH_4_PATH;
        String imageString29 = Constants.COCKROACH_4_PATH;
        String imageString30 = Constants.COCKROACH_4_PATH;
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
        this.images.add(imageString11);
        this.images.add(imageString12);
        this.images.add(imageString13);
        this.images.add(imageString14);
        this.images.add(imageString15);
        this.images.add(imageString16);
        this.images.add(imageString17);
        this.images.add(imageString18);
        this.images.add(imageString19);
        this.images.add(imageString20);
        this.images.add(imageString21);
        this.images.add(imageString22);
        this.images.add(imageString23);
        this.images.add(imageString24);
        this.images.add(imageString25);
        this.images.add(imageString26);
        this.images.add(imageString27);
        this.images.add(imageString28);
        this.images.add(imageString29);
        this.images.add(imageString30);
        this.height = Constants.COCKROACH_HEIGHT;
        this.width = Constants.COCKROACH_WIDTH;
    }
}
