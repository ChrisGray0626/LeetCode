package pers.chris.Stack.checkValidString;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    leftStack.push(i);
                    break;
                case '*':
                    asteriskStack.push(i);
                    break;
                case ')':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    else if (!asteriskStack.isEmpty()) {
                        asteriskStack.pop();
                    }
                    else {
                        return false;
                    }
                    break;
                default:
            }
        }

        // 右括号用完后，对比左括号与星号
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIdx = leftStack.pop();
            int asteriskIdx = asteriskStack.pop();
            // 星号的位置必须比左括号靠右
            if (leftIdx > asteriskIdx) {
                return false;
            }
        }
        // 检查是否有左括号剩余
        return leftStack.isEmpty();
    }
}
