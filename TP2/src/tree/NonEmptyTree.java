package tree;

public class NonEmptyTree extends Tree {
    private Object carga;
    private Tree left;
    private Tree right;

    public NonEmptyTree(Object carga) {
        this.carga = carga;
        this.left = new EmptyTree(); // Inicializa con nodos vacios
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
    /*super(tree);*/

    public Tree atLeft(Tree left) {
        this.left = left;
        return this;
    }

    public Tree atRight(Tree right) {
        this.right = right;
        return this;
    }

    public Tree left() {
        return this.left; // Nodo vacio devuelve a si mismo
    }

    public Tree right() {
        return this.right; // Nodo vacio devuelve a si mismo
    }

    public Object carga() {
        return this.carga;
    }

}
