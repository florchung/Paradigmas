package tree;

import java.util.LinkedList;
import java.util.List;

public class Tree {
    private Object carga;
    private Tree left;
    private Tree right;

    public Tree(Object carga) {
        this.carga = carga;
    }

    public List<Object> dfs() {
        List<Object> result = new LinkedList<>();
        dfsHelper(this, result);
        return result;
    }

    private void dfsHelper (Tree node, List<Object> result) {
        if (node == null) {
            return;
        }
        result.add(node.carga);
        dfsHelper(node.left, result);
        dfsHelper(node.right, result);
    }

    public List<Object> bfs() {
        List<Object> result = new LinkedList<>();
        List<Tree> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree current = queue.remove(0);
            result.add(current.carga);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }

    public Tree atLeft( Tree left ) {
        this.left = left;
        return this;
    }

    public Tree atRight( Tree right ) {
        this.right = right;
        return this;
    }

    public Tree left() {
        if (this.left == null) {
            throw new RuntimeException("Nada a la siniestra!");
        }
        return this.left;
    }

    public Tree right() {
        if (this.right == null) {
            throw new RuntimeException("Nada a la diestra!");
        }
        return this.right;
    }

    public Object carga() {
        return this.carga;
    }
}
