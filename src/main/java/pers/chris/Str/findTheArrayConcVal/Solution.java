package pers.chris.Str.findTheArrayConcVal;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/12
 */
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        long res = 0;
        for (int i = 0; i < n / 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]).append(nums[n - 1 - i]);
            res += Integer.parseInt(sb.toString());
        }
        if (n % 2 == 1) {
            res += nums[n / 2];
        }
        return res;
    }
}