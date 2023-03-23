package pers.chris.Array.majorityElement2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int n = nums.length;
        if (n == 1) {
            res.add(nums[0]);
            return res;
        }

        int candidate1 = Integer.MAX_VALUE;
        int candidate2 = Integer.MAX_VALUE;
        int vote1 = 0;
        int vote2 = 0;
        for (int num: nums) {
            if (candidate1 == num) {
                vote1++;
            }
            else if (candidate2 == num) {
                vote2++;
            }
            else if (vote1 == 0) {
                candidate1 = num;
                vote1++;
            }
            else if (vote2 == 0) {
                candidate2 = num;
                vote2++;
            }

            else {
                vote1--;
                vote2--;
            }
        }

        vote1 = 0;
        vote2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                vote1++;
            }
            if (candidate2 == num) {
                vote2++;
            }
        }

        if (vote1 > n / 3) {
            res.add(candidate1);
        }
        if (vote2 > n / 3) {
            res.add(candidate2);
        }
        return res;
    }
}
