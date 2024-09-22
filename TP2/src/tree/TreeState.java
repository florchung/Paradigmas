package tree;

import java.util.*;

public abstract class TreeState {
    public abstract Tree getTree(String side);
    public abstract List<Object> dfs();
    public abstract void addToQueue(Queue<Tree> queue);
}
