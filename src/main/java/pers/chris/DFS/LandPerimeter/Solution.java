package pers.chris.DFS.LandPerimeter;

class Solution {

    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};
    int m, n;
    int[][] grid;

    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;

        int res = 0;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (grid[i][j] == 1){
                    res += dfs(i, j);
                }
            }
        }
        return res;
    }

    public int dfs(int row, int col){
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0){
            return 1;
        }

        if (grid[row][col] == -1){
            return 0;
        }

        grid[row][col] = -1;

        int res = 0;
        for (int i = 0; i < 4; i ++){
            res += dfs(dx[i] + row, dy[i] + col);
        }

        return res;
    }
}
