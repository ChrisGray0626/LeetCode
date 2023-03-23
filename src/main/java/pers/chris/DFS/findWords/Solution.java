package pers.chris.DFS.findWords;

import java.util.*;

public class Solution {

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    char[][] board;
    private Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        Trie trie = new Trie();
        res = new HashSet<>();

        // 建立前缀树
        for (String word: words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(trie, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Trie cur, int i, int j) {
        char ch = board[i][j];
        // 当前字符不在前缀树中，剪枝
        if (!cur.children.containsKey(ch)) {
            return;
        }

        cur = cur.children.get(ch);
        String word = cur.word;
        if (!"".equals(word)) {
            res.add(word);
        }

        board[i][j] = '#'; // 标记为已访问

        for (int[] dir: dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            if (nextI >= 0 && nextI < board.length
                    && nextJ >= 0 && nextJ < board[0].length) {
                dfs(cur, nextI, nextJ);
            }
        }

        board[i][j] = ch;
    }
}

class Trie {
    public String word;
    public Map<Character, Trie> children;

    public Trie() {
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }

}