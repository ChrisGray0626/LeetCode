package pers.chris.Hash.numberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int[] pointP: points) {
            Map<Integer, Integer> disCnt = new HashMap<>();

            for (int[] pointQ: points) {
                int dis = (int) (Math.pow((pointP[0] - pointQ[0]), 2) + Math.pow((pointP[1] - pointQ[1]), 2));
                disCnt.put(dis, disCnt.getOrDefault(dis, 0) + 1);
            }

            for (int value: disCnt.values()) {
                res += value * (value - 1);
            }
        }
        return res;
    }

}
