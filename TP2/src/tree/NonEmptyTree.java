package tree;

import java.util.*;

public class NonEmptyTree extends TreeState {
    private final Tree tree;

    public NonEmptyTree(Tree tree) {
        this.tree = tree;
    }

    @Override
    public Tree getTree(String side) {
        return this.tree;
    }

    @Override
    public List<Object> dfs() {
        return tree.dfs();
    }

    @Override
    public void addToQueue(Queue<Tree> queue) {
        queue.add(this.tree);
    }
}
