package tree;

import java.util.LinkedList;
import java.util.List;

class EmptyTree extends Tree {

    public EmptyTree(Object carga){
        super( null );
    }
    public void left(Tree b){
        throw new RuntimeException("Nada a la siniestra!");
    }
    public void right(Tree a){
        throw new RuntimeException("Nada a la diestra!");
    }
    public Object carga(){
        return this;
    }
    private Object dfsHelper(Tree node, List result){
        return this;
    }
    public List<Object> dfs(){
        List<Object> result = new LinkedList();
        dfsHelper(this,result);
        return result;
    }
    public List<Object> bfs(){
        List<Object> result = new LinkedList();
        return result;
    }
    public Tree atLeft(Tree left){
        return this;
    }
    public Tree atRight(Tree right){
        return this;
    }


}
