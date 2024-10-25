package MarsRoverProject;

public class East extends Direction {
    public String name = "East";

    public Direction turnRight() {
        return new South();
    }

    public Direction turnLeft() {
        return new North();
    }

    public void move(MarsRover rover) {
        rover.updatePosition(new Point(1, 0));
    }

    public void moveBack(MarsRover rover) {
        rover.updatePosition(new Point(-1, 0));
    }
}
