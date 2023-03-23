package pers.chris.DynamicProgramming.FindCheapestPrice;

import java.util.Arrays;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];
        final int INF = 10000 * 101 + 1;

        for (int i = 0; i <= k + 1; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;

        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
            }
        }

        int res = INF;

        for (int t = 1; t <= k + 1; t++) {
            res = Math.min(res, dp[t][dst]);
        }
        return res == INF ? -1 : res;
    }
}
