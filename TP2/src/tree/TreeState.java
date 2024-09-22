package tree;

import java.util.*;

public abstract class TreeState {
    public abstract Tree getLeftOrThrow();
    public abstract Tree getRightOrThrow();
    public abstract List<Object> dfs();
    public abstract void addToQueue(Queue<Tree> queue);
}
