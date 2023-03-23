package pers.chris.BFS.OpenLock;

import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Set<String> dead = new HashSet<>();
        Collections.addAll(dead, deadends);

        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");

        while (!queue.isEmpty()) {
            step ++;
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                String status = queue.poll();
                List<String> next = getNext(status);
                for (String ss: next) {
                    if (ss.equals(target)) {
                        return step;
                    }
                    if (!visited.contains(ss) && !dead.contains(ss)) {
                        queue.add(ss);
                        visited.add(ss);
                    }
                }

            }
        }
        return -1;
    }

    public List<String> getNext(String status) {
        List<String> next = new ArrayList<>();
        char[] ss = status.toCharArray();
        for (int i = 0; i < 4; i ++) {
            char num = ss[i];
            ss[i] = numAdd(num);
            next.add(new String(ss));
            ss[i] = numSub(num);
            next.add(new String(ss));
            ss[i] = num;
        }
        return next;
    }

    public char numAdd(char ch) {
        return ch == '9' ? '0' : (char) (ch + 1);
    }

    public char numSub(char ch) {
        return ch == '0' ? '9' : (char) (ch - 1);
    }

}
