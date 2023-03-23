package pers.chris.Simulation.luckyNumbers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];
        Arrays.fill(minRow, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                minRow[i] = Math.min(minRow[i], num);
                maxCol[j] = Math.max(maxCol[j], num);
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = matrix[i][j];
                if (num == minRow[i] && num == maxCol[j]) {
                    res.add(num);
                }
            }
        }
        return res;
    }
}
