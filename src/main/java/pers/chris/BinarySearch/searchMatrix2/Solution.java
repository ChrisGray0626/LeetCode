package pers.chris.BinarySearch.searchMatrix2;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] col : matrix) {
            int l = 0;
            int r = matrix[0].length - 1;

            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (col[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (col[l] == target) {
                return true;
            }
        }
        return false;
    }
}
