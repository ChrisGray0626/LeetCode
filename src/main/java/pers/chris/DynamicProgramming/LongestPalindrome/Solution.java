package pers.chris.DynamicProgramming.LongestPalindrome;

public class Solution {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        int begin = 0;
        int maxLen = 1;

        // 所有长度为1的字符串都是回文串
        for (int i = 0; i < len; i ++) {
            dp[i][i] = true;
        }

        // 根据长度枚举
        for (int l = 2; l <= len; l ++) {
            for (int i = 0; i < len; i ++) {
                int j = i + l - 1;

                if (j >= len) {
                    break;
                }

                if ((s.charAt(i) != s.charAt(j))) {
                    dp[i][j] = false;
                }
                // 所有长度为2且两字符相等的都是回文串
                else if (l == 2) {
                    dp[i][j] = true;
                }
                else {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                if (dp[i][j] && (l > maxLen)) {
                    maxLen = l;
                    begin = i;
                }
            }
        }
    return s.substring(begin, begin + maxLen);
    }
}
