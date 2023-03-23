package pers.chris.DynamicProgramming.MinimumTotal;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int high = triangle.size();
        int[][] dp = new int[high][high];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 0; i <= high - 1; i ++) {
            dp[high - 1][i] = triangle.get(high - 1).get(i);
        }

        for (int i = high - 2; i >= 0; i --) {
            for (int j = 0; j <= i; j ++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
