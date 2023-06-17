package pers.chris.Math.majorityElement;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/13
 */
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;

        for (int num: nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
