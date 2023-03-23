package pers.chris.Hash.LeastBricks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row: wall){
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i ++){
                sum += row.get(i);
                int num = map.getOrDefault(sum, 0);
                map.put(sum, ++ num);
            }
        }
        int high = wall.size();
        int res = high;

        for (int value: map.values()){
            res = Math.min(res, high - value);
        }

        return res;
    }
}
