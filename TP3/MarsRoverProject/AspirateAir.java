package MarsRoverProject;

public class AspirateAir extends Message {
    public AspirateAir() {
        super('a');
    }

    public void Execute(MarsRover rover) {
        rover.aspirateAir();
    }
}
