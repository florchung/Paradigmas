package tree;

import java.util.ArrayList;
import java.util.List;

class EmptyTree extends TreeState {
    public Tree left() {
        throw new RuntimeException("Nada a la siniestra!");
    }

    public Tree right() {
        throw new RuntimeException("Nada a la diestra!");
    }

    public List<Object> dfs(List<Object> result) {
        return new ArrayList();
    }
}
