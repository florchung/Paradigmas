package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {
    private Object carga;
    private TreeState left;
    private TreeState right;

    public Tree(Object carga) {
        this.carga = carga;
        this.left = new EmptyTree();
        this.right = new EmptyTree();
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
        return left.getTree("siniestra");
    }

    public Tree right() {
        return right.getTree("diestra");
    }

    public List<Object> dfs() {
        List<Object> result = new ArrayList<>();
        result.add(this.carga);
        result.addAll(left.dfs());
        result.addAll(right.dfs());
        return result;
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
        left.addToQueue(queue);
        right.addToQueue(queue);
    }
}
