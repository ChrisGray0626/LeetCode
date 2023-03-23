package pers.chris.Simulation.findRepeatNumber;

class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        int res = -1;
        for (int num: nums) {
            count[num]++;
            if (count[num] > 1) {
                res = num;
                break;
            }
        }
        return res;
    }
}
