package pers.chris.DynamicProgramming.LargestNumber;

import java.util.Arrays;

public class Solution {

    public String largestNumber(int[] cost, int target) {
        // 使用前 i+1 个数位且花费总成本恰好为 j 时的最大位数
        int[][] dp = new int[10][target + 1];
        int[][] from = new int[10][target + 1];


        for (int i = 0; i < 10; i ++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < target + 1; j ++) {
                if (j < cost[i]) {
                    dp[i + 1][j] = dp[i][j];
                    from[i + 1][j] = j;
                }
                else {
                    if (dp[i][j] > dp[i + 1][j - cost[i]] + 1) {
                        dp[i + 1][j] = dp[i][j];
                        from[i + 1][j] = j;
                    }
                    else {
                        dp[i + 1][j] = dp[i + 1][j - cost[i]] + 1;
                        from[i + 1][j] = j - cost[i];
                    }
                }
            }
        }

        if (dp[9][target] < 0) {
            return "0";
        }

        StringBuffer sb = new StringBuffer();
        int i = 9;
        int j = target;
        while (i > 0) {
            // 转移位置不变，说明当前数位没有被选择
            if (j == from[i][j]) {
                i --;
            }
            else {
                sb.append(i);
                j = from[i][j];
            }
        }

        return sb.toString();
    }
}
