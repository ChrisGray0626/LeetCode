package pers.chris.Array.exchange;

/**
 * @Description
 * @Author Chris
 * @Date 2023/4/1
 */
class Solution {
    public int[] exchange(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (nums[l] % 2 == 1 && l < r) {
                l++;
            }
            while (nums[r] % 2 == 0 && l < r) {
                r--;
            }
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }

        return nums;
    }
}
