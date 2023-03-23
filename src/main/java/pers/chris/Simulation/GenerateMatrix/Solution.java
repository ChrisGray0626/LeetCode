package pers.chris.Simulation.GenerateMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIdx = 0;
        int x = 0;
        int y = 0;

        for (int i = 1; i <= n * n; i ++){
            res[x][y] = i;

            int nextX = x + directions[directionIdx][0];
            int nextY = y + directions[directionIdx][1];
            if (nextX >= n || nextY >= n || nextX < 0 || nextY < 0 || res[nextX][nextY] != 0) {
                directionIdx ++;
                directionIdx %= 4;
            }
            x += directions[directionIdx][0];
            y += directions[directionIdx][1];
        }

        return res;
    }
}
