package pers.chris.Contest.Single256.minimumDifference;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }

        int len = nums.length;
        Queue<Integer> diffs = new PriorityQueue<>((a, b) -> (a - b));

        Arrays.sort(nums);
        k--;
        for (int i = k; i < len; i++) {
            diffs.add(nums[i] - nums[i - k]);
        }
        return diffs.poll();
    }
}
