package pers.chris.BFS.kSimilarity;


import javafx.util.Pair;

import java.util.*;

class Solution {
    public int kSimilarity(String s1, String s2) {
        int len = s1.length();
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Pair<>(s1, 0));
        visited.add(s1);

        while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();
            String cur = pair.getKey();
            int step = pair.getValue();

            if (cur.equals(s2)) {
                return step;
            }

            int idx = 0;
            // 剪枝，找到第一个不同的字符
            while (cur.charAt(idx) == s2.charAt(idx)) {
                idx++;
            }

            for (int i = idx + 1; i < len; i++) {
                // 剪枝，找到第一个不同的字符
                if (cur.charAt(i) == s2.charAt(i)) {
                    continue;
                }
                // 找到与 s2[idx] 相同的字符，交换
                if (cur.charAt(i) == s2.charAt(idx)) {
                    String next = swap(cur, idx, i);
                    if (!visited.contains(next)) {
                        queue.offer(new Pair<>(next, step + 1));
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
