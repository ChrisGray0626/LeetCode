package pers.chris.DynamicProgramming.isMatch;

import java.util.Arrays;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/31
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (isMatched(s, p, i, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if ('*' == p.charAt(j - 1)) {
                    if (isMatched(s, p, i, j - 1)) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    private boolean isMatched(String s, String p, int i, int j) {
        if (0 == i) {
            return false;
        }
        i--;
        j--;
        if ('.' == p.charAt(j)) {
            return true;
        }

        return s.charAt(i) == p.charAt(j);
    }
}