package pers.chris.Math.isSelfCrossing;

class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;

        for (int i = 3; i < n; i++) {
            // 第一类情况
            if (distance[i - 1] <= distance[i - 3]
                    && distance[i] >= distance[i - 2]) {
                return true;
            }

            // 第二类情况
            else if (i == 4
                    && distance[i - 2] >= distance[i - 4]
                    && distance[i - 1] == distance[i - 3]
                    && distance[i] >= distance[i - 2] - distance[i - 4]) {
                return true;
            }

            // 第三类情况
            else if (i > 4
                    && distance[i - 1] <= distance[i - 3]
                    && distance[i - 2] >= distance[i - 4]
                    && distance[i] >= distance[i - 2] - distance[i - 4]
                    && distance[i - 1] >= distance[i - 3] - distance[i - 5]) {
                return true;
            }
        }
        return false;
    }
}
