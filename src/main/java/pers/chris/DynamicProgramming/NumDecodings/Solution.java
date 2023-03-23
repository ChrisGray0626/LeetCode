package pers.chris.DynamicProgramming.NumDecodings;

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;

        for (int i = 1; i <= len; i ++) {
            // 一个字符编码，判断i-1位是否合法
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // 两个字符编码，判断i-1与i-2位是否合法
            if (i != 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <=26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len];
    }
}
