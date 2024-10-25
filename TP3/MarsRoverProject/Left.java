package MarsRoverProject;

public class Left extends Message {
    public Left() {
        super('l');
    }

    public void Execute(MarsRover rover) {
        rover.turnLeft();
    }
}
