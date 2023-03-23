package pers.chris.Hash.MaxPoints;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int res = 0;

        for (int i = 0; i < n; i++) {
            //当直线上的数大于n/2时，此直线上的数最多，没有其他直线的数会大于n/2
            //第i个点所在直线的数目res >= n-i时返回，从第i个节点出发最多找到n-i个点在同一直线上
            if (res > n / 2 || res >= n - i) {
                break;
            }

            Map<Integer,Integer> map = new HashMap<>();

            // 如果与前面的某点共线，则不需要重复计算；否则亦不需要考虑
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                if (dy == 0) {
                    dx = 1;
                } else if (dx == 0) {
                    dy = 1;
                } else {
                    // 保证分子始终为正数
                    if (dy < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    int gcdXY = gcd(Math.abs(dx), Math.abs(dy));
                    dx /= gcdXY;
                    dy /= gcdXY;
                }
                int key = dy + dx * 200001;
                map.put(key, map.getOrDefault(key, 1) + 1);
            }
            int maxSum = 0;
            for (int value: map.values()) {
                maxSum = Math.max(maxSum, value);
            }
            res = Math.max(res, maxSum);
        }
        return res;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
