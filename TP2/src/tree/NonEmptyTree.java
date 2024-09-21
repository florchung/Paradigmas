package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NonEmptyTree extends TreeState {
    private Tree tree;


    public NonEmptyTree(Tree tree) {
        this.tree = tree;

    }

    public Tree left() {
        return tree;
    }

    public Tree right() {
        return tree;
    }
   public List<Object> dfs(List<Object> result) {
       result.add(left().carga());
       return result;
    }

/*
    public List<Object> bfs() {
        List<Object> result = new ArrayList<>();
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
    }*/
}
