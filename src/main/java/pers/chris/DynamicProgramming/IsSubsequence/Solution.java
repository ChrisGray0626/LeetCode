package pers.chris.DynamicProgramming.IsSubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[n + 1][26];

        // 边界条件设置
        for (int i = 0; i < 26; i ++) {
            dp[m][i] = m;
        }

        // 逆序枚举初始化dp数组
        for (int i = m - 1; i >=0; i --) {
            for (int j = 0; j < 26; j ++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int next = 0;
        for (int i = 0; i < n; i ++) {
            // 达到边界条件，未能满足s
            if (dp[next][s.charAt(i) - 'a'] == m) {
                return false;
            }
            // 位置next移动至t中第一次出现字符s(i)位置的后一位
            next = dp[next][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }
}
