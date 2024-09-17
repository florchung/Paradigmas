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
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public char carga() {
        return carga;
    }

    @Override
    public TreeState left() {
        return left;
    }

    @Override
    public TreeState right() {
        return right;
    }

    @Override
    public TreeState atLeft(TreeState left) {
        return new NonEmptyTree(carga, left, right);
    }

    @Override
    public TreeState atRight(TreeState right) {
        return new NonEmptyTree(carga, left, right);
    }

    @Override
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

    @Override
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
