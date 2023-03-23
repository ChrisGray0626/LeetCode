package pers.chris.Str.Calculate;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        s = s.replace(" ", "");

        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if (!Character.isDigit(ch)){
                switch (op){
                    case '+': stack.push(num);
                    break;
                    case '-': stack.push(- num);
                    break;
                    case '*': stack.push(stack.pop() * num);
                    break;
                    case '/': stack.push(stack.pop() / num);
                    break;
                }
                op = ch;
                num = 0;
            }
            else {
                num = num * 10 + (ch - '0');
            }
        }

        switch (op){
            case '+': stack.push(num);
                break;
            case '-': stack.push(- num);
                break;
            case '*': stack.push(stack.pop() * num);
                break;
            case '/': stack.push(stack.pop() / num);
                break;
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
