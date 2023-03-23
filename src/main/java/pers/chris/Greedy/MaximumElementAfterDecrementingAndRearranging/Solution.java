package pers.chris.Greedy.MaximumElementAfterDecrementingAndRearranging;

import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return 1;
        }
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < len; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }
        return arr[len - 1];
    }
}
