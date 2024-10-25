package MarsRoverProject;

public class Backward extends Message {
    public Backward() {
        super('b');
    }

    public void Execute(MarsRover rover) {
        rover.backward();
    }
}
