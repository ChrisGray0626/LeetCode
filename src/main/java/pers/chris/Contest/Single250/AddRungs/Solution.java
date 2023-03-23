package pers.chris.Contest.Single250.AddRungs;

class Solution {
    public int addRungs(int[] rungs, int dist) {
        int len = rungs.length;
        if (len == 0) {
            return 0;
        }

        int cnt = 0;
        for (int i = 1; i < len; i ++) {
            int gap = rungs[i] - rungs[i - 1] - 1;
            if (gap >= dist) {
                cnt += gap / dist;
            }
        }
        if (rungs[0] - 1 >= dist) {
            cnt += (rungs[0] - 1) / dist;
        }
        return cnt;
    }
}
