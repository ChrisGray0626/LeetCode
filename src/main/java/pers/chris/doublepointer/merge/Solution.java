package pers.chris.doublepointer.merge;

/**
 * @Description
 * @Author Chris
 * @Date 2023/8/13
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = 0, idx2 = 0;
        int[] res = new int[m + n];
        int idx = 0;
        while (idx1 < m && idx2 < n) {
            if (nums1[idx1] < nums2[idx2]) {
                res[idx] = nums1[idx1];
                idx1++;
            }
            else {
                res[idx] = nums2[idx2];
                idx2++;
            }
            idx++;
        }
        if (idx1 < m) {
            System.arraycopy(nums1, idx1, res, idx, m - idx1);
        }
        else if (idx2 < n) {
            System.arraycopy(nums2, idx2, res, idx, n - idx2);
        }
        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);
    }
}
