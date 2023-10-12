package pers.chris.Greedy.splitNum;

import java.util.Arrays;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/9
 */
class Solution {
    public int splitNum(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        Arrays.sort(numChars);

        int num1 = 0, num2 = 0;
        for (int i = 0; i < numChars.length; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + numChars[i] - '0';
            }
            else {
                num2 = num2 * 10 + numChars[i] - '0';
            }
        }
        return num1 + num2;
    }
}
