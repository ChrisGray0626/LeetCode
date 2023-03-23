package pers.chris.DynamicProgramming.findLongestWord;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        int len = s.length();
        int[][] dp = new int[len + 1][26];

        // 最后一位起所有字符默认出现在最后一位
        Arrays.fill(dp[len], len);
        // 字符串预处理，自i位起字符j第一次出现的位置
        for (int i = len - 1; i >=0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == 'a' + j) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        String res = "";
        for (String ss: dictionary) {
            boolean match = true;
            int idx = 0;

            for (int i = 0; i < ss.length(); i++) {
                int ch = ss.charAt(i) - 'a';
                if (dp[idx][ch] == len) {
                    match = false;
                    break;
                }

                // idx移动至匹配字符所在位置的下一位
                idx = dp[idx][ch] + 1;
            }

            if (match) {
                // 长度最长且字典序最小
                if (ss.length() > res.length() ||  (ss.length() == res.length() && ss.compareTo(res) < 0)) {
                    res = ss;
                }
            }
        }
        return res;
    }
}
