
package tree;

import java.util.ArrayList;
import java.util.List;

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
        List<Object> result = new ArrayList();
        result.add(carga);
        result.add(left.left().carga());
        left().dfs(result);
        return result;
        //este dfs no lo hice con emilio asi q puede estar mal
    }


    public List<Object> bfs() {
        return null;
    }
}
