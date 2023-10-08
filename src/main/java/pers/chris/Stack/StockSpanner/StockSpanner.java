package pers.chris.Stack.StockSpanner;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/7
 */
class StockSpanner {

    private final Deque<Pair<Integer, Integer>> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.add(new Pair<>(Integer.MAX_VALUE, 0));
    }

    public int next(int price) {
        int span = 1;
        while (price >= stack.peek().getKey()) {
            span += stack.poll().getValue();
        }
        stack.push(new Pair<>(price, span));

        return span;
    }
}