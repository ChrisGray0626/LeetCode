package pers.chris.DynamicProgramming.Partition;

import java.util.ArrayList;
import java.util.List;

class Solution {
    boolean[][] dp;
    int len;
    List<List<String>> res = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        len = s.length();
        dp = new boolean[len][len];

        for (int i = 0; i < len; i ++) {
            dp[i][i] = true;
        }

        for (int i = len - 1; i >= 0; i --) {
            for (int j= i + 1; j < len; j ++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] || j - i <= 2);
            }
        }

        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i) {
        if (i == len) {
            res.add(new ArrayList<String>(ans));
            return;
        }

        for (int j = i; j < len; j ++) {
            if (dp[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
