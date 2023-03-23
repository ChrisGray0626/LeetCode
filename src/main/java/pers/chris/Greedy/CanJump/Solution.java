package pers.chris.Greedy.CanJump;

public class Solution {
    public boolean canJump(int[] nums) {
        int maxDis = 0;
        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            if (i > maxDis) {
                return false;
            }

            maxDis = Math.max(maxDis, i + nums[i]);
            if (maxDis >= len - 1) {
                return true;
            }
        }
        return false;
    }
}
