package tree;

import java.util.List;
import java.util.Queue;

class NonEmptyTree extends TreeState {
    private Tree tree;

    public NonEmptyTree(Tree tree) {
        this.tree = tree;
    }

    public Tree left() {
        return tree.left();
    }

    public Tree right() {
        return tree.right();
    }

    public void dfs(List<Object> result) {
        tree.dfs(result);  // Delegamos la llamada DFS al nodo interno del árbol
    }

    public void enqueueChildren(Queue<Tree> queue) {
        queue.add(tree);  // Agregamos el nodo a la cola
    }
}
