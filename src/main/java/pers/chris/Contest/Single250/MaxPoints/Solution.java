package pers.chris.Contest.Single250.MaxPoints;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[m][n];

        for(int i = 0; i < n; i ++) {
            dp[0][i] = points[0][i];
        }

        for (int i = 1; i < m; i ++) {
            long lMax = 0;
            for (int j = 0; j < n; j++) {
                lMax = Math.max(lMax - 1, dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], lMax);
            }

            long rMax = 0;
            for (int j = n - 1; j >= 0; j--) {
                rMax = Math.max(rMax - 1, dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], rMax);
            }

            for (int j = 0; j < n; j++) {
                dp[i][j] += points[i][j];
            }
        }
        long maxScore = 0;
        for (long score: dp[m - 1]) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
