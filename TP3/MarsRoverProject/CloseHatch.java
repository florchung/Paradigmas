package MarsRoverProject;

public class CloseHatch extends Message {
    public CloseHatch() {
        super('c');
    }

    public void Execute(MarsRover rover) {
        rover.closeHatches();
    }
}
