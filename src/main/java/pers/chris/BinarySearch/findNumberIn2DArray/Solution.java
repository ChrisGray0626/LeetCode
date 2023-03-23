package pers.chris.BinarySearch.findNumberIn2DArray;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean res = false;

        for (int[] col: matrix) {
            res = binarySearch(col, target);
            if (res) {
                break;
            }
        }
        return res;
    }

    public boolean binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
