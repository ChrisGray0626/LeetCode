package pers.chris.Contest.Single260.maximumDifference;

import java.util.Arrays;

class Solution {
    public int maximumDifference(int[] nums) {
        int len = nums.length;
        int[] maxs = new int[len];
        int[] mins = new int[len];

        Arrays.fill(maxs, Integer.MIN_VALUE);
        Arrays.fill(mins, Integer.MAX_VALUE);
        mins[0] = nums[0];
        maxs[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            maxs[i] = Math.max(maxs[i + 1], nums[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            int diff = maxs[i] - mins[i];
            res = Math.max(res, diff);
        }
        return res == 0 ? -1 : res;
    }
}
