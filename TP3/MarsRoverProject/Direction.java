package MarsRoverProject;

import java.util.Objects;

public abstract class Direction {
    public String name;
    public abstract Direction turnRight();
    public abstract Direction turnLeft();
    public abstract void move(MarsRover rover);
    public abstract void moveBack(MarsRover rover);

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Direction)) {
            return false;
        }
        Direction other = (Direction) obj;
        return Objects.equals(name, other.name);
    }
}
