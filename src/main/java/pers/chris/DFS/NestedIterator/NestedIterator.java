package pers.chris.DFS.NestedIterator;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {

    private Deque<Integer> queue;

    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new ArrayDeque<>();
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext()? queue.pollFirst(): - 1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public void dfs (List<NestedInteger> nestedList) {
        for (NestedInteger nest: nestedList) {
            if (nest.isInteger()) {
                queue.addLast(nest.getInteger());
            }
            else {
                dfs(nest.getList());
            }
        }
    }
}