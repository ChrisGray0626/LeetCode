package pers.chris.Math.missingTwo;

class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int sum = 0;

        for (int num: nums) {
            sum += num;
        }
        // 求消失的两数之和
        int sumTwo = n * (n + 1) / 2 - sum;
        int mean = sumTwo / 2;
        sum = 0;
        // 求消失的两数中较小的数，将问题转化为求消失的一个数
        for (int num: nums) {
            if (num <= mean) {
                sum += num;
            }
        }
        int x1 = mean * (mean + 1) / 2 - sum;
        int x2 = sumTwo - x1;

        return new int[] {x1, x2};
    }
}
