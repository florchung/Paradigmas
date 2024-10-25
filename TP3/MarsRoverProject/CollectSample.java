package MarsRoverProject;

public class CollectSample extends Message {
    public CollectSample() {
        super('i');
    }

    public void Execute(MarsRover rover) {
        rover.collectSample();
    }
}
