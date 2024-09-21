package tree;

import java.util.List;
import java.util.Queue;

public abstract class TreeState {
    public abstract Tree left();
    public abstract Tree right();
    public abstract void dfs(List<Object> result);
    public abstract void enqueueChildren(Queue<Tree> queue);
}
