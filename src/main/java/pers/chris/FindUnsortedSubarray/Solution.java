package pers.chris.FindUnsortedSubarray;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int left = -1;
        int right = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < len;i ++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
            else {
                right = i;
            }
        }

        for (int i = len - 1; i >= 0;i --) {
            if (nums[i] <= min) {
                min = nums[i];
            }
            else {
                left = i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
