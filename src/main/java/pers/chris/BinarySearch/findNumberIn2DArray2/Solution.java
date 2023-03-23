package pers.chris.BinarySearch.findNumberIn2DArray2;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        boolean res = false;

        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                res = true;
                break;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}

