package tree;

import java.util.List;

public class Tree {
    private final TreeState state;

    // Constructor para un solo carácter
    public Tree(char carga) {
        this.state = new NonEmptyTree(carga, new EmptyTree(), new EmptyTree());
    }

    // Constructor para una cadena (conversión de String a char)
    public Tree(String carga) {
        if (carga.length() != 1) {
            throw new IllegalArgumentException("String must be of length 1");
        }
        this.state = new NonEmptyTree(carga.charAt(0), new EmptyTree(), new EmptyTree());
    }

    // Constructor para TreeState
    private Tree(TreeState state) {
        this.state = state;
    }

    public Tree atLeft(Tree left) {
        return new Tree(state.atLeft(left.state));
    }

    public Tree atRight(Tree right) {
        return new Tree(state.atRight(right.state));
    }

    public boolean isEmpty() {
        return state.isEmpty();
    }

    public char carga() {
        return state.carga();
    }

    public Tree left() {
        return new Tree(state.left());
    }

    public Tree right() {
        return new Tree(state.right());
    }

    public List<Character> dfs() {
        return state.dfs();
    }

    public List<Character> bfs() {
        return state.bfs();
    }
}
