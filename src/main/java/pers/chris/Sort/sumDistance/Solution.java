package pers.chris.Sort.sumDistance;

import java.util.Arrays;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/10
 */
class Solution {

    static final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        int n = nums.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = nums[i] - d;
            }
            else {
                pos[i] = nums[i] + d;
            }
        }
        Arrays.sort(pos);

        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += (pos[i] - pos[i - 1]) * i % MOD * (n - i) % MOD;
            sum %= MOD;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,0,2};
        String s = "RLL";
        int d = 3;
        solution.sumDistance(nums, s, d);
    }
}
