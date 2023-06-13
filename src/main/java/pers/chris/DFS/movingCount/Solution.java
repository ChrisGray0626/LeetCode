package pers.chris.DFS.movingCount;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/7
 */
class Solution {

    private int count = 0;
    private boolean[][] visited;
    private int k;
    public int movingCount(int m, int n, int k) {
        this.k = k;
        visited = new boolean[m][n];
        search(0, 0);

        return count;
    }

    private void search(int i, int j) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j] || !isAccessed(i, j)) {
            return;
        }

        visited[i][j] = true;
        count++;
        search(i + 1, j);
        search(i, j + 1);
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
