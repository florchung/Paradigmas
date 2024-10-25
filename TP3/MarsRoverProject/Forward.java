package MarsRoverProject;

public class Forward extends Message {
    public Forward() {
        super('f');
    }

    public void Execute(MarsRover rover) {
        rover.forward();
    }
}
