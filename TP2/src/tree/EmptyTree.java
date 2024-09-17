package tree;

import java.util.Collections;
import java.util.List;

class EmptyTree extends TreeState {
    public boolean isEmpty() {
        return true;
    }

    public char carga() {
        throw new IllegalStateException("Tree is empty");
    }

    public TreeState left() {
        throw new IllegalStateException("Tree is empty");
    }

    public TreeState right() {
        throw new IllegalStateException("Tree is empty");
    }

    public TreeState atLeft(TreeState left) {
        return new NonEmptyTree(' ', left, this); // Arbitrary value for root
    }

    public TreeState atRight(TreeState right) {
        return new NonEmptyTree(' ', this, right); // Arbitrary value for root
    }

    public List<Character> dfs() {
        return Collections.emptyList();
    }

    public List<Character> bfs() {
        return Collections.emptyList();
    }
}
