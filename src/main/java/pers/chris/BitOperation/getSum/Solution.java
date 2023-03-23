package pers.chris.BitOperation.getSum;

class Solution {
    public int getSum(int a, int b) {
        /*
        a ^ b 亦或计算无进位加法结果
        (a & b) << 1 与计算来自前一位的进位结果
        两者亦或运算即为加法结果
         */
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
