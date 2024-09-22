package tree;

import java.util.*;

public class EmptyTree extends TreeState {

    public Tree left() {
        throw new RuntimeException("Nada a la siniestra!");
    }

    public Tree right() {
        throw new RuntimeException("Nada a la diestra!");
    }

    public List<Object> dfs() {
        return new ArrayList<>();
    }

    public void addToQueue(Queue<Tree> queue) {
    }
}
