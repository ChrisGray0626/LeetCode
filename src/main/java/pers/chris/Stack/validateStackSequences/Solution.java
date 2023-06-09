package pers.chris.Stack.validateStackSequences;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/8
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int i = 0;
        for (int num: pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}