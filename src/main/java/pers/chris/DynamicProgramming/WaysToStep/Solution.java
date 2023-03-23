package pers.chris.DynamicProgramming.WaysToStep;

class Solution {
    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        final int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        return dp[n];
    }
}
