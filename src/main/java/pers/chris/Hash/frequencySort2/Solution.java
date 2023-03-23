package pers.chris.Hash.frequencySort2;

import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(100);

        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(count.entrySet());
        entries.sort((o1, o2) -> {
            if (o2.getValue().equals(o1.getValue())) {
                return o2.getKey() - o1.getKey();
            }
            return o1.getValue() - o2.getValue();
        });

        int[] res = new int[nums.length];
        int idx = 0;

        for (Map.Entry<Integer, Integer> entry: entries) {
            int num = entry.getKey();
            int sum = entry.getValue();
            for (int i = 0; i < sum; i ++) {
                res[idx++] = num;
            }
        }
        return res;
    }
}
