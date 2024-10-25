package MarsRoverProject;

public class MarsRover {
    private Direction direction;
    public Coordinates coordenadas;
    private boolean upperHatchOpen = false;
    private boolean lowerHatchOpen = false;

    public MarsRover(Point point, Direction direction) {
        this.direction = direction;
        this.coordenadas = new Coordinates(point);
    }

    public void receiveMessage(String string) {
        string.chars().forEach(letter -> receiveChar((char) letter));
    }

    public void receiveChar(char letter) {
        Message.getAvailableMessages(letter).Execute(this);
    }

    public void forward() {
        this.direction.move(this);
    }

    public void backward() {
        this.direction.moveBack(this);
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void openUpperHatch() {
        if (lowerHatchOpen) {
            throw new RuntimeException("Cannot open upper hatch while lower hatch is open.");
        }
        this.upperHatchOpen = true;
    }

    public void openLowerHatch() {
        if (upperHatchOpen) {
            throw new RuntimeException("Cannot open lower hatch while upper hatch is open.");
        }
        this.lowerHatchOpen = true;
    }

    public void closeHatches() {
        if (!upperHatchOpen && !lowerHatchOpen) {
            throw new RuntimeException("No hatches are open.");
        }
        upperHatchOpen = false;
        lowerHatchOpen = false;
    }

    public void aspirateAir() {
        if (!upperHatchOpen) {
            throw new RuntimeException("Cannot aspirate air with upper hatch closed.");
        }
        // aspirate air logic
    }

    public void collectSample() {
        if (!lowerHatchOpen) {
            throw new RuntimeException("Cannot collect sample with lower hatch closed.");
        }
        // collect sample logic
    }

    public void updatePosition(Point point) {
        this.coordenadas.updateCoordinates(point);
    }

    public Point getCoordinates() {
        return this.coordenadas.getPosition();
    }

    public Direction getDirection() {
        return this.direction;
    }
}
