package pers.chris.Hash.PairSums;

import java.util.*;

class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums){
            int value = map.getOrDefault(num, 0);
            map.put(num, ++ value);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int key: map.keySet()){
            int pair = target - key;
            int value1 = map.get(key);
            int value2 = map.getOrDefault(pair, 0);

            if (value1 == 0 || value2 == 0){
                continue;
            }

            if (key == pair){
                if (value1 == 1){
                    continue;
                }

                value1 /= 2;
            }

            for (int i = 0; i < Math.min(value1, value2); i ++) {
                res.add(Arrays.asList(key, pair));
            }

            map.put(pair, 0);
            map.put(key, 0);
        }

        return res;
    }
}
