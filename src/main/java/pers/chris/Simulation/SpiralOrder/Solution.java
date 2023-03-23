package pers.chris.Simulation.SpiralOrder;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIdx = 0;
        boolean[][] vis = new boolean[row][col];
        int x = 0;
        int y = 0;

        for (int i = 0; i < total; i ++){
            res.add(matrix[x][y]);
            vis[x][y] = true;

            int nextX = x + directions[directionIdx][0];
            int nextY = y + directions[directionIdx][1];
            if (nextX >= row || nextY >= col || nextX < 0 || nextY < 0 || vis[nextX][nextY]) {
                directionIdx ++;
                directionIdx %= 4;
            }
            x += directions[directionIdx][0];
            y += directions[directionIdx][1];
        }
        return res;
    }
}
