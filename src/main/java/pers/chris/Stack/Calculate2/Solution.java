package pers.chris.Stack.Calculate2;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate(" 3/2 "));
    }
    public int calculate(String s) {
        char preOpt = '+';
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)){
                num = ch - '0' + num * 10;
            }
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1){
                switch (preOpt){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(- num);
                        break;
                    case '*':
                        num = stack.pop() * num;
                        stack.push(num);
                        break;
                    case '/':
                        num  = stack.pop() / num;
                        stack.push(num);
                    default:
                        break;
                }

                num = 0;
                preOpt = ch;
            }

        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }

        return res;
    }
}
