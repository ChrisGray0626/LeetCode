package pers.chris.Hash.unequalTriplets;

import java.util.*;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/13
 */
class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.merge(num, 1, Integer::sum);
        }

        int count = 0;
        int leftCount = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int midCount = entry.getValue();
            int rightCount = nums.length - leftCount - midCount;
            count += leftCount * midCount * rightCount;
            leftCount += midCount;
        }
        return count;
    }
}
