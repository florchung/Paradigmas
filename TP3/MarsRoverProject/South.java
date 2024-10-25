package MarsRoverProject;

public class South extends Direction {
    public String name = "South";

    public Direction turnRight() {
        return new West();
    }

    public Direction turnLeft() {
        return new East();
    }

    public void move(MarsRover rover) {
        rover.updatePosition(new Point(0, -1));
    }

    public void moveBack(MarsRover rover) {
        rover.updatePosition(new Point(0, 1));
    }
}
