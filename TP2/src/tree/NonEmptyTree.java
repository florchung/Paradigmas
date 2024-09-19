package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NonEmptyTree extends TreeState {
    private char carga;
    private TreeState left;
    private TreeState right;

    public NonEmptyTree(char carga, TreeState left, TreeState right) {
        this.carga = carga;
        // Si no se especifican, los lados deben ser EmptyTree
        this.left = (left == null) ? new EmptyTree() : left;
        this.right = (right == null) ? new EmptyTree() : right;
    }

    public boolean isEmpty() {
        return false;
    }

    public char carga() {
        return carga;
    }

    public TreeState left() {
        return left;
    }

    public TreeState right() {
        return right;
    }

    public TreeState atLeft(TreeState left) {
        return new NonEmptyTree(carga, left, right);
    }

    public TreeState atRight(TreeState right) {
        return new NonEmptyTree(carga, left, right);
    }

    public List<Character> dfs() {
        List<Character> result = new ArrayList<>();
        dfsHelper(this, result);
        return result;
    }

    private void dfsHelper(TreeState node, List<Character> result) {
        if (node.isEmpty()) {
            return;
        }
        NonEmptyTree nonEmptyNode = (NonEmptyTree) node;
        result.add(nonEmptyNode.carga);
        dfsHelper(nonEmptyNode.left, result);
        dfsHelper(nonEmptyNode.right, result);
    }

    public List<Character> bfs() {
        List<Character> result = new ArrayList<>();
        Queue<TreeState> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeState node = queue.poll();
            if (node.isEmpty()) {
                continue;
            }
            NonEmptyTree nonEmptyNode = (NonEmptyTree) node;
            result.add(nonEmptyNode.carga);
            queue.add(nonEmptyNode.left);
            queue.add(nonEmptyNode.right);
        }

        return result;
    }
}
