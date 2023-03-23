package pers.chris.Stack.Calculate;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("1+1"));
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int sign = 1;
        int res = 0;

        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);

            if (ch == '+'){
                sign = stack.peek();
            }
            else if (ch == '-'){
                sign = - stack.peek();
            }
            else if (ch == '('){
                stack.push(sign);
            }
            else if (ch == ')'){
                stack.pop();
            }
            else if (Character.isDigit(ch)){
                long cur = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))){
                    cur = s.charAt(i) - '0' + cur * 10;
                    i ++;

                }

                res += sign * cur;
                i --;
            }
        }

        return res;
    }
}
