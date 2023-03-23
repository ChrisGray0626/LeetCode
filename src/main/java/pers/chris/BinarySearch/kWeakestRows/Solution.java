package pers.chris.BinarySearch.kWeakestRows;

import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] counts = new int[m][2];

        for (int i = 0; i < m; i ++) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                    pos = mid;
                }
            }
            counts[i][0] = pos + 1;
            counts[i][1] = i;
        }

        Arrays.sort(counts, (a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));

        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = counts[i][1];
            System.out.println(counts[i][0]);
        }

        return res;
    }
}
