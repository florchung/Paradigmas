package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    private Object carga;
    private TreeState left = new EmptyTree();
    private TreeState right = new EmptyTree();

    public Tree(Object carga) {
        this.carga = carga;
    }

    public Tree atLeft(Tree left) {
        this.left = new NonEmptyTree(left);
        return this;
    }

    public Tree atRight(Tree right) {
        this.right = new NonEmptyTree(right);
        return this;
    }

    public Object carga() {
        return carga;
    }

    public Tree left() {
        return left.left();
    }

    public Tree right() {
        return right.right();
    }

    public List<Object> dfs() {
        List<Object> result = new ArrayList<>();
        dfs(result);
        return result;
    }

    protected void dfs(List<Object> result) {
        result.add(carga);
        left.dfs(result);
        right.dfs(result);
    }

    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            result.add(current.carga());
            current.enqueueChildren(queue);
        }
        return result;
    }

    private void enqueueChildren(Queue<Tree> queue) {
        left.enqueueChildren(queue);
        right.enqueueChildren(queue);
    }
}
