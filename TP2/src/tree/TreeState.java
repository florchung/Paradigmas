package tree;

import java.util.*;

public abstract class TreeState {
    public abstract Tree left();
    public abstract Tree right();
    public abstract List<Object> dfs();
    public abstract void addToQueue(Queue<Tree> queue);
}
