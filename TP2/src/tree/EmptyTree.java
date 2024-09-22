package tree;

import java.util.*;

public class EmptyTree extends TreeState {
    @Override
    public Tree getTree(String side) {
        throw new RuntimeException("Nada a la " + side + "!");
    }

    @Override
    public List<Object> dfs() {
        return new ArrayList<>();
    }

    @Override
    public void addToQueue(Queue<Tree> queue) {
        // No hay nada que agregar
    }
}
