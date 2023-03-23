package pers.chris.Stack.EvalRPN;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String token: tokens){
            if (isNum(token)){
                int num = Integer.parseInt(token);
                stack.push(num);
            }
            else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token){
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    public boolean isNum(String ss){
        return !(ss.equals("+") || ss.equals("-") || ss.equals("*") || ss.equals("/"));
    }
}
