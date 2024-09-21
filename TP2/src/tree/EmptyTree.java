package tree;

import java.util.List;
import java.util.Queue;

class EmptyTree extends TreeState {
    public Tree left() {
        throw new RuntimeException("Nada a la siniestra!");
    }

    public Tree right() {
        throw new RuntimeException("Nada a la diestra!");
    }

    public void dfs(List<Object> result) {
        // No hacemos nada porque es un nodo vacío
    }

    public void enqueueChildren(Queue<Tree> queue) {
        // No agregamos nada a la cola porque es un nodo vacío
    }
}
