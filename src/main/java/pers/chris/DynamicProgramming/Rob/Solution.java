package pers.chris.DynamicProgramming.Rob;

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }

        int dp0 = 0;
        int dp1 = nums[0];

        for (int i = 1; i < len; i ++){
            int tmp = dp0;
            dp0 = Math.max(tmp, dp1);
            dp1 = tmp + nums[i];
        }

        return Math.max(dp0, dp1);
    }
}
