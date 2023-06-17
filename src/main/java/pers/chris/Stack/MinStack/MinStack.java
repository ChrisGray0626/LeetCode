package pers.chris.Stack.MinStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * @Author Chris
 * @Date 2023/4/3
 */
class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(x, minStack.peek()));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
