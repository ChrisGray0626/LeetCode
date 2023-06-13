package pers.chris.DFS.tilingRectangle;

/**
 * @Description
 * @Author Chris
 * @Date 2023/6/8
 */
class Solution {

    int minCnt = Integer.MAX_VALUE;
    boolean[][] filled;
    int n, m;

    public int tilingRectangle(int n, int m) {
        this.n = n;
        this.m = m;
        filled = new boolean[n][m];
        dfs(0, 0, 0);

        return minCnt;
    }

    private void dfs(int x, int y, int cnt) {
        // 抵达右边界，换行
        if (y == m) {
            dfs(x + 1, 0, cnt);
            return;
        }
        // 抵达下边界，结束
        if (x == n) {
            minCnt = cnt;
            return;
        }
        if (filled[x][y]) {
            dfs(x, y + 1, cnt);
        }
        // 如果继续填充，则超过当前最小值，结束
        if (++cnt >= minCnt) {
            return;
        }
        int maxLen = Math.min(n - x, m - y);
        for (int i = 1; i <= maxLen; i++) {
            if (isFilled(x, y, i)) {
                break;
            }
            fill(x, y, i);
            dfs(x, y + i, cnt);
            unFill(x, y, i);
        }
    }

    private boolean isFilled(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (filled[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void fill(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                filled[i][j] = true;
            }
        }
    }

    private void unFill(int x, int y, int len) {
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                filled[i][j] = false;
            }
        }
    }
}
