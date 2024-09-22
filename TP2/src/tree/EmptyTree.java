package tree;

import java.util.*;

public class EmptyTree extends TreeState {
    private final String side;

    public EmptyTree(String side) {
        this.side = side;
    }

    public Tree getLeftOrThrow() {
        throw new RuntimeException("Nada a la " + side + "!");
    }

    public Tree getRightOrThrow() {
        throw new RuntimeException("Nada a la " + side + "!");
    }

    public List<Object> dfs() {
        return new ArrayList<>();
    }

    public void addToQueue(Queue<Tree> queue) {
        // No hay nada que agregar
    }
}
