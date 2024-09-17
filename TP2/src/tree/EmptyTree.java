package tree;

class EmptyTree extends Tree {
    private Object carga = carga;
    private Tree left = left;
    private Tree right = right;

    public EmptyTree(Object carga){
        super( carga );
    }
    public void left(Tree b){
        throw new RuntimeException("Nada a la siniestra!");
    }
    public void right(Tree a){
        throw new RuntimeException("Nada a la diestra!");
    }
    public Object carga(){
        return null;
    }


}
