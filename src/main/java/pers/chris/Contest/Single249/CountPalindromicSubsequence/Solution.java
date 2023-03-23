package pers.chris.Contest.Single249.CountPalindromicSubsequence;

import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        int cnt = 0;
        if (len <= 2) {
            return 0;
        }

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < len; i ++) {
            char ch = s.charAt(i);
            List<Integer> idxList = map.getOrDefault(ch, new ArrayList<>());
            idxList.add(i);
            map.put(ch, idxList);
        }

        for (List<Integer> idxList: map.values()) {
            int size = idxList.size();
//            if (size == 1) {
//                continue;
//            }
            Set<Character> charSet = new HashSet<>();

            for (int i = 0; i < size; i ++) {
                for (int j = i + 1; j < size; j ++) {
                    for (int k = idxList.get(i) + 1;k < idxList.get(j); k ++) {
                        charSet.add(s.charAt(k));
                    }
                }
            }
            cnt += charSet.size();
        }
        return cnt;
    }
}
