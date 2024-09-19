package tree;

import java.util.Collections;
import java.util.List;

class EmptyTree extends TreeState {
    public boolean isEmpty() {
        return true;
    }

    public char carga() {
        throw new IllegalStateException("Tree vacío!");
    }

    public TreeState left() {
        throw new IllegalStateException("Nada a la siniestra!");
    }

    public TreeState right() {
        throw new IllegalStateException("Nada a la diestra!");
    }

    public TreeState atLeft(TreeState left) {
        return new NonEmptyTree(' ', left, this);
    }

    public TreeState atRight(TreeState right) {
        return new NonEmptyTree(' ', this, right);
    }

    public List<Character> dfs() {
        return Collections.emptyList();
    }

    public List<Character> bfs() {
        return Collections.emptyList();
    }
}
