package pers.chris.Array.shuffle;

import java.util.Random;

class Solution {

    private final int[] nums;
    private final Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] res = nums.clone();
        int n = res.length;

        for (int i = 0; i < n; i++) {
            int j = i + random.nextInt(n - i);

            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
        }
        return res;
    }
}
