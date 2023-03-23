package pers.chris.Greedy.Jump;

public class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        int maxPos = 0;
        int step = 0;
        int end = 0;

        for (int i = 0; i < len; i ++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (end == i) {
                step ++;
                end = maxPos;
            }
        }
        return step;
    }
}
