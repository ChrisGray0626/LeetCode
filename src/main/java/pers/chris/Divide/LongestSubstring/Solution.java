package pers.chris.Divide.LongestSubstring;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestSubstring(String s, int k) {

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i ++){
            count[s.charAt(i) - 'a'] ++;
        }

        List<Integer> splits = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++){
            if (count[s.charAt(i) - 'a'] < k){
                splits.add(i);
            }
        }
        if (splits.isEmpty()){
            return s.length();
        }

        splits.add(s.length());

        int res = 0;
        int left = 0;
        for (int split: splits){
            int len = split - left;
            if (len > res){
                res = Math.max(res, longestSubstring(s.substring(left, split), k));
            }

            left = split + 1;
        }

        return res;
    }
}
