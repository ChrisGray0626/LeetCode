package pers.chris.Simulation.spiralOrder2;/**
 * @Description
 * @Author Chris
 * @Date 2023/4/3

 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (0 == matrix.length) {
            return new int[0];
        }
        int m = matrix[0].length;
        int n = matrix.length;
        int l = 0;
        int r = m - 1;
        int t = 0;
        int b = n - 1;
        int[] res = new int[m * n];
        int idx = 0;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[idx++] = matrix[t][i];
            }
            t++;
            if (t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[idx++] = matrix[i][r];
            }
            r--;
            if (r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[idx++] = matrix[b][i];
            }
            b--;
            if (b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[idx++] = matrix[i][l];
            }
            l++;
            if (l > r) {
                break;
            }
        }

        return res;
    }
}
