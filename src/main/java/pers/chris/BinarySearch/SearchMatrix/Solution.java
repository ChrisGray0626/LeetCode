package pers.chris.BinarySearch.SearchMatrix;

class Solution {

    int m,n,target;
    boolean flag = false;
    int[][] matrix;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        m = matrix.length;
        n = matrix[0].length;

        search(0, m * n - 1);

        return flag;
    }

    public void search(int left, int right){
        if (left > right){
            return ;
        }

        int pivotIdx = (left + right) / 2;
        int pivotEle = matrix[pivotIdx / n][pivotIdx % n];
        if (target == pivotEle){
            flag = true;
            return;
        }
        else if (target < pivotEle){
            right = pivotIdx - 1;
        }
        else {
            left = pivotIdx + 1;
        }

        search(left, right);

    }
}
