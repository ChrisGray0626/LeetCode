package pers.chris.Contest.Single233.MaxAscendingSum;

class Solution {
    public int maxAscendingSum(int[] nums) {
        int len =nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int countTmp = 0;
        for (int i = 1; i < len; i ++){
            if (nums[i] > nums[i - 1]){
                countTmp += nums[i];
            }
            else {
                countTmp = nums[i];
            }
            dp[i] = Math.max(countTmp, dp[i - 1]);
        }

        return dp[len - 1];
    }
}
