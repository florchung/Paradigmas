package tree;

import java.util.LinkedList;
import java.util.List;

public abstract class Tree {
    public abstract List<Object> dfs();
    public abstract List<Object> bfs();

    public abstract Tree atLeft(Tree left);
    public abstract Tree atRight(Tree right);

    private abstract Tree left;
    private abstract Tree right;
    private abstract Object carga;
}

class EmptyTree extends Tree {
    public List<Object> dfs() {
        return new LinkedList<>();
    }

    public List<Object> bfs() {
        return new LinkedList<>();
    }

    public Tree atLeft(Tree left) {
        throw new UnsupportedOperationException("Operación no válida en un árbol vacío");
    }

    public Tree atRight(Tree right) {
        throw new UnsupportedOperationException("Operación no válida en un árbol vacío");
    }

    public Tree left() {
        throw new RuntimeException("Nada a la siniestra!");
    }

    public Tree right() {
        throw new RuntimeException("Nada a la diestra!");
    }

    public Object carga() {
        throw new UnsupportedOperationException("Un árbol vacío no tiene carga");
    }
}

class NonEmptyTree extends Tree {
    private Object carga;
    private Tree left;
    private Tree right;

    public NonEmptyTree(Object carga) {
        this.carga = carga;
        this.left = new EmptyTree();
        this.right = new EmptyTree();
    }

    public List<Object> dfs() {
        List<Object> result = new LinkedList<>();
        result.add(carga);
        result.addAll(left.dfs());
        result.addAll(right.dfs());
        return result;
    }

    public List<Object> bfs() {
        List<Object> result = new LinkedList<>();
        List<Tree> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree current = queue.remove(0);
            result.add(current.carga());
            if (!(current.left() instanceof EmptyTree)) {
                queue.add(current.left());
            }
            if (!(current.right() instanceof EmptyTree)) {
                queue.add(current.right());
            }
        }
        return result;
    }

    public Tree atLeft(Tree left) {
        this.left = left;
        return this;
    }

    public Tree atRight(Tree right) {
        this.right = right;
        return this;
    }

    public Tree left() {
        return this.left();
    }

    public Tree right() {
        return this.right();
    }
    public Object carga() {
        return this.carga;
    }
}
