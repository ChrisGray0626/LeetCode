package pers.chris.BinarySearch.findPeakElement;

public class Solution {

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + r >> 1;
            // 爬坡法，峰值一定在高处的方向
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
