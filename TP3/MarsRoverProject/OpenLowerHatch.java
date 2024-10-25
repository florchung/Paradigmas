package MarsRoverProject;

public class OpenLowerHatch extends Message {
    public OpenLowerHatch() {
        super('o');
    }

    public void Execute(MarsRover rover) {
        rover.openLowerHatch();
    }
}
