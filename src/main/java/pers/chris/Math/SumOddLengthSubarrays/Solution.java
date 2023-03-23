package pers.chris.Math.SumOddLengthSubarrays;



class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l1 = (i + 1) / 2, r1 = (n - i) / 2; // 奇数
            int l2 = i / 2, r2 = (n - i - 1) / 2; // 偶数
            l2++; r2++;
            ans += (l1 * r1 + l2 * r2) * arr[i];
        }
        return ans;
    }
}