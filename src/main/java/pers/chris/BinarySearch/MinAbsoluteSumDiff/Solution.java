package pers.chris.BinarySearch.MinAbsoluteSumDiff;

import java.util.Arrays;

class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1000000007;
        int n = nums1.length;
        if (n == 1) {
            return Math.abs(nums1[0] - nums2[0]);
        }

        int maxDiff = 0;
        int maxIdx = 0;
        int sum = 0;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        for (int i = 0; i < n; i ++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
                maxIdx = i;
            }

            sum = (sum + diff % MOD) % MOD;
        }

        int dest = nums2[maxIdx];
        int l = 0, r = n - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (rec[mid] < dest) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        int alteredDiff;
        if (l + 1 < n) {
            alteredDiff = Math.min(Math.abs(rec[l] - nums2[maxIdx]), Math.abs(rec[l + 1] - nums2[maxIdx]));
        }
//        if (l - 1  {
//            alteredDiff = Math.min(Math.abs(rec[l] - nums2[maxIdx]), Math.abs(rec[l + 1] - nums2[maxIdx]));
//        }
            
        alteredDiff = Math.abs(rec[l] - nums2[maxIdx]);
        sum = (sum - maxDiff + alteredDiff) % MOD;
        return sum;
    }
}
