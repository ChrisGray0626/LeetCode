package pers.chris.PrefixSum.PivotIndex;

import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;

        for (int i = 0; i < nums.length; i ++){
            if (total * 2 + nums[i] == sum){
                return i;
            }
            total += nums[i];
        }

        return -1;
    }
}
