package MarsRoverProject;

public class North extends Direction {
    public String name = "North";

    public Direction turnRight() {
        return new East();
    }

    public Direction turnLeft() {
        return new West();
    }

    public void move(MarsRover rover) {
        rover.updatePosition(new Point(0, 1));
    }

    public void moveBack(MarsRover rover) {
        rover.updatePosition(new Point(0, -1));
    }
}
