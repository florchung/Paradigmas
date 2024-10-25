package MarsRoverProject;

public class West extends Direction {
    public String name = "West";

    public Direction turnRight() {
        return new North();
    }

    public Direction turnLeft() {
        return new South();
    }

    public void move(MarsRover rover) {
        rover.updatePosition(new Point(-1, 0));
    }

    public void moveBack(MarsRover rover) {
        rover.updatePosition(new Point(1, 0));
    }
}
