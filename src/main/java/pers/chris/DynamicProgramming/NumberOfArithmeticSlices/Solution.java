package pers.chris.DynamicProgramming.NumberOfArithmeticSlices;

import java.util.Arrays;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        for (int i = 2; i < len; i ++) {
            if (nums[i] + nums[i - 2] == nums[i - 1] * 2) {
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = 0;
            }
        }

        int res = 0;
        for (int i = 0; i < len; i ++) {
            res += dp[i];
        }
        return res;
    }
}
