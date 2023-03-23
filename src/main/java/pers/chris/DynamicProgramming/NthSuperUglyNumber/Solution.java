package pers.chris.DynamicProgramming.NthSuperUglyNumber;

import java.util.Arrays;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] points = new int[len];
        int[] dp = new int[n + 1];
        dp[1] = 1;

        Arrays.fill(points, 1);
        for (int i = 2; i <=n ;i ++) {
            int[] nums = new int[len];
            int minNum = Integer.MAX_VALUE;

            for (int j = 0; j < len; j++) {
                nums[j] = dp[points[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }

            dp[i] = minNum;

            for (int j = 0; j < len; j++) {
                if (minNum == nums[j]) {
                    points[j]++;
                }
            }
        }
        return dp[n];
    }
}