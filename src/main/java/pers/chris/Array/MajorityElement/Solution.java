package pers.chris.Array.MajorityElement;

class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int candidate = nums[0];
        int cnt = 1;
        for (int i = 1; i < len; i++) {
            if (cnt == 0) {
                candidate = nums[i];
            }

            if (candidate == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        cnt = 0;
        for (int num : nums) {
            if (candidate == num) {
                cnt++;
            }
        }
        return cnt * 2 > len ? candidate : -1;
    }
}
