package pers.chris.DynamicProgramming.NumberOfArithmeticSlices2;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        Map<Long, Integer>[] dp = new Map[len];
        int res = 0;
        for (int i = 0; i < len; i ++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                long diff = (long) nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(diff, 0);
                res += cnt;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + cnt + 1);
            }
        }
        return res;
    }
}
