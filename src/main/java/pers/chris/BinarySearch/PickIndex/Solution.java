package pers.chris.BinarySearch.PickIndex;

import java.util.Arrays;

class Solution {

    private int[] pre;
    private int sum;

    public Solution(int[] w) {
        int len = w.length;
        pre = new int[len];
        pre[0] = w[0];

        for (int i = 1; i < len; i++) {
            pre[i] = pre[i - 1] + w[i];
        }
        sum = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int idx = (int) (Math.random() * sum) + 1;
        return binarySearch(idx);
    }

    private int binarySearch(int x) {
        int l = 0, r = pre.length - 1;

        while (l < r) {
            int mid = l + r >> 1;
            if (pre[mid] < x) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }
}
