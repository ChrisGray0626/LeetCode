package pers.chris.BFS.movingCount;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/7
 */
class Solution {

    private int k;

    public int movingCount(int m, int n, int k) {
        this.k = k;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || !isAccessed(i, j)) {
                continue;
            }
            visited[i][j] = true;
            count++;
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return count;
    }


    private boolean isAccessed(int i, int j) {
        return calcBitSum(i) + calcBitSum(j) <= k;
    }

    private int calcBitSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
