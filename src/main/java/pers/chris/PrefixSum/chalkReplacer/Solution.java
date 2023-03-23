package pers.chris.PrefixSum.chalkReplacer;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        if (chalk[0] > k) {
            return 0;
        }

        int len = chalk.length;
        int[] pre = new int[len];

        pre[0] = chalk[0];
        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] + chalk[i];
            // 如果超过粉笔总数，则必然落在当前学生手中
            if (pre[i] > k) {
                return i;
            }
        }

        k %= pre[len - 1];

        return binarySearch(pre, k);
    }
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;

        while (l < r) {
            int mid = l + r >> 1;
            if (target >= nums[mid]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

}
