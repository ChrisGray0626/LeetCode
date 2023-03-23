package pers.chris.Greedy.findMinMoves;

import java.util.Arrays;

public class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int total = Arrays.stream(machines).sum();

        // 无法平衡
        if (total % n != 0) {
            return -1;
        }

        int avg = total / n;
        int res = 0, sum = 0;

        for (int num: machines) {
            num -= avg; // i位置需要调整的次数
            sum += num; // 位置0到i需要调整的总次数

            res = Math.max(res, Math.max(Math.abs(sum), num));
        }
        return res;
    }
}
