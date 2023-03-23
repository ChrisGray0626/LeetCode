package pers.chris.BinarySearch.FindKthSmallest;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right){
            int mid = (left + right) / 2;
            if (k > check(matrix, mid)){
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }

    public int check(int[][] matrix, int mid){
        int n = matrix.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n && j >= 0){
            if (mid >= matrix[i][j]){
                i ++;
                count += j + 1;
            }
            else {
                j --;
            }
        }

        return count;
    }
}
