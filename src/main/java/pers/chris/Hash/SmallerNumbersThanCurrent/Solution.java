package pers.chris.Hash.SmallerNumbersThanCurrent;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] count = new int[101];

        for (int num: nums){
            count[num] ++;
        }

        for (int i = 1; i < count.length; i ++){
            count[i] += count[i - 1];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < res.length; i ++){
            res[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return res;
    }
}
