package model;

import constants.Constants;
import utilities.Direction;
import java.util.ArrayList;

import static utilities.Direction.EAST;
import static utilities.Direction.WEST;

public class Wasp extends Bug {

    public Wasp(int x, int y, Direction direction, int difficulty) {
        super(x, y, Constants.WASP_SPEED * (difficulty + 1), Constants.WASP_SPEED * (difficulty + 1), direction);
        this.points = Constants.POINTS_WASP;
        this.images = new ArrayList<>();
        String imageString1 = Constants.WASP_1_PATH;
        String imageString2 = Constants.WASP_1_PATH;
        String imageString3 = Constants.WASP_2_PATH;
        String imageString4 = Constants.WASP_2_PATH;
        this.images.add(imageString1);
        this.images.add(imageString2);
        this.images.add(imageString3);
        this.images.add(imageString4);
        this.height = Constants.WASP_HEIGHT;
        this.width = Constants.WASP_WIDTH;
    }

    //metodo vuoto in quanto la vespa non cambia mai direzione finchè non raggiunge un bordo
    @Override
    public void changeDirection(int mouseX, int mouseY) {
        //
    }

    @Override
    public void changeDirectionBorder() {
        if (this.isInBorderX1() && this.direction == WEST) {
            this.direction = EAST;
            this.x -= 50;
            this.y += 70;
        } else if (this.isInBorderX2() && this.direction == EAST) {
            this.direction = WEST;
            this.x += 50;
            this.y += 70;
        }
    }
}
