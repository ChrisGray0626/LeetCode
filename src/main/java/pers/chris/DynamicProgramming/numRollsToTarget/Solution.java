package pers.chris.DynamicProgramming.numRollsToTarget;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/24
 */
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][]dp = new int[n + 1][target + 1];
        int MOD = 1000000007;
        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                for (int l = 1; l < k + 1; l++) {
                    if (j > l) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
