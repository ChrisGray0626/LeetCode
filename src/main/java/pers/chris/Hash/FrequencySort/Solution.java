package pers.chris.Hash.FrequencySort;

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i ++) {
            char ch = s.charAt(i);
            int sum = map.getOrDefault(ch, 0) + 1;
            map.put(ch, sum);
        }

        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a, b) -> (map.get(b) - map.get(a)));

        StringBuilder res = new StringBuilder();

        for (char ch: chars) {
            int sum = map.get(ch);
            for (int i = 0; i < sum; i ++) {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
