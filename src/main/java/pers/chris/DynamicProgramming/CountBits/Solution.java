package pers.chris.DynamicProgramming.CountBits;

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int highBit = 0; // 最高有效位

        for (int i = 1; i <= n; i ++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }

            dp[i] = dp[i - highBit] + 1;
        }

        return dp;
    }
}
