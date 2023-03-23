package pers.chris.Divide.SearchMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;
        boolean flag = false;

        while (row <= matrix.length - 1 && col >= 0){
            if (matrix[row][col] > target){
                col --;
            }
            else if (matrix[row][col] < target){
                row ++;
            }
            else {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
