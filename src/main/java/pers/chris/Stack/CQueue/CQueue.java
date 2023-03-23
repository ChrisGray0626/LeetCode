package pers.chris.Stack.CQueue;

import java.util.Stack;

class CQueue {

    private final Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        // 如果 outStack 为空，将 inStack 中的元素全部压入 outStack
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        // 如果 outStack 仍为空，说明 inStack 也为空，返回 -1
        if (outStack.isEmpty()) {
            return -1;
        }
        else {
            return outStack.pop();
        }
    }
}
