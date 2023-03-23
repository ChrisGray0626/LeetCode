package pers.chris.Contest.Single248.EliminateMaximum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n ; i ++) {
            int time = (int) Math.ceil((double) dist[i] / speed[i]);
            int sum = map.getOrDefault(time, 0) + 1;
            map.put(time, sum);
        }
        int sum = 0;
        for (int i = 1; i <= n; i ++) {
            if (map.containsKey(i)) {
                sum += map.get(i);
                if (i - sum < 0) {
                    return i;
                }
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] dis = {4, 3, 3, 3, 4};
        int[] speed = {1, 1, 1, 1, 4};
        System.out.println(solution.eliminateMaximum(dis, speed));
    }
}
