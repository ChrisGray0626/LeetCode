package pers.chris.DFS.exist;

class Solution {

    private char[][] board;
    private String word;
    private int m;
    private int n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        // 从每个位置开始搜索
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int idx) {
        // 如果数组越界、当前位置已访问或当前字符与目标字符不匹配，返回 false
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
        // 递归次数等于目标字符串长度，说明已经匹配到最后一个字符
        if (idx == word.length() - 1) {
            return true;
        }
        // 标记当前位置已访问
        visited[i][j] = true;
        idx++;
        // 向当前位置的四个方向继续搜索，只要有一个方向能匹配到，就返回 true
        boolean res = dfs(i + 1, j, idx) || dfs(i - 1, j, idx) || dfs(i, j + 1, idx) || dfs(i, j - 1, idx);
        // 回溯，将当前位置标记为未访问
        visited[i][j] = false;

        return res;
    }
}
