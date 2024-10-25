package MarsRoverProject;

public class OpenUpperHatch extends Message {
    public OpenUpperHatch() {
        super('O');
    }

    public void Execute(MarsRover rover) {
        rover.openUpperHatch();
    }
}
