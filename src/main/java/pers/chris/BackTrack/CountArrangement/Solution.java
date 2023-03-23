package pers.chris.BackTrack.CountArrangement;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    int num;
    List<Integer>[] matches;
    boolean[] vis;

    public int countArrangement(int n) {
        this.n = n;
        num = 0;
        matches = new List[n + 1];
        vis = new boolean[n + 1];

        for (int i = 1; i <= n; i ++) {
            matches[i] = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    matches[i].add(j);
                }
            }
        }
        backTrack(1);
        return num;

    }

    public void backTrack(int idx) {
        if (idx == n + 1) {
            num ++;
            return;
        }

        for (int num: matches[idx]) {
            if (!vis[num]) {
                vis[num] = true;
                backTrack(idx + 1);
                vis[num] = false;
            }
        }
    }
}
