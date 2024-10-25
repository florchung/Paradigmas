package MarsRoverProject;

public class Right extends Message {
    public Right() {
        super('r');
    }

    public void Execute(MarsRover rover) {
        rover.turnRight();
    }
}
