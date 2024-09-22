package tree;

import java.util.*;

public class NonEmptyTree extends TreeState {
    private final Tree tree;

    public NonEmptyTree(Tree tree) {
        this.tree = tree;
    }

    public Tree getLeftOrThrow() {
        return this.tree;
    }

    public Tree getRightOrThrow() {
        return this.tree;
    }

    public List<Object> dfs() {
        return tree.dfs();
    }

    public void addToQueue(Queue<Tree> queue) {
        queue.add(this.tree);
    }
}
