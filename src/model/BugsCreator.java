package model;

import utilities.Direction;

public class BugsCreator {

    public Fly createNewFly(int x, int y, Direction direction, int difficulty){
        return new Fly(x, y, direction, difficulty);
    }
    public Wasp createNewWasp(int x, int y, Direction direction, int difficulty){
        return new Wasp(x, y, direction, difficulty);
    }
    public Butterfly createNewButterfly(int x, int y, Direction direction, int difficulty){
        return new Butterfly(x, y, direction, difficulty);
    }
    public Ladybug createNewLadybug(int x, int y, Direction direction, int difficulty){
        return new Ladybug(x, y, direction, difficulty);
    }
    public Cockroach createNewCockroach(int x, int y, Direction direction, int difficulty){
        return new Cockroach(x, y, direction, difficulty);
    }
}
