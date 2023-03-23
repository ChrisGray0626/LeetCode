package pers.chris.Contest.Single249.GetConcatenation;

import java.util.Arrays;

class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] res = new int[2 * len];
        System.arraycopy(nums, 0, res, 0, len);
        System.arraycopy(nums, 0, res, len, len);
        return res;
    }
}
