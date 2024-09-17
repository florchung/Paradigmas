package tree;

import java.util.List;

public abstract class TreeState {
    public abstract boolean isEmpty();
    public abstract char carga();
    public abstract TreeState left();
    public abstract TreeState right();
    public abstract TreeState atLeft(TreeState left);
    public abstract TreeState atRight(TreeState right);
    public abstract List<Character> dfs();
    public abstract List<Character> bfs();
}
