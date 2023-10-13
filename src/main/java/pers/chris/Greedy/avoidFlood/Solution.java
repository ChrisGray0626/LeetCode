package pers.chris.Greedy.avoidFlood;

import java.util.*;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/13
 */
class Solution {
    public int[] avoidFlood(int[] rains) {
        TreeSet<Integer> sunnyDays = new TreeSet<>();
        Map<Integer, Integer> fullLakes = new HashMap<>();
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                sunnyDays.add(i);
            }
            else {
                // If the lake is full, find a sunny day to empty it
                if (fullLakes.containsKey(rains[i])) {
                    // If there was no sunny day, return empty array
                    if (sunnyDays.isEmpty()) {
                        return new int[0];
                    }
                    // Find the first sunny day before the rainy day
                    else {
                        int lastRainyDay = fullLakes.get(rains[i]);
                        Integer sunday = sunnyDays.ceiling(lastRainyDay);
                        if (sunday == null) {
                            return new int[0];
                        }
                        res[sunday] = rains[i];
                        sunnyDays.remove(sunday);
                    }
                }
                fullLakes.put(rains[i], i);
            }
        }
        // Fill the rest sunny days
        for (int sunnyDay : sunnyDays) {
            res[sunnyDay] = 1;
        }
        return res;
    }
}
