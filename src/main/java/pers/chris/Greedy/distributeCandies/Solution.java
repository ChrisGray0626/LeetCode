package pers.chris.Greedy.distributeCandies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();

        for (Integer candy: candyType) {
            set.add(candy);
        }
        return Math.min(n / 2, set.size());
    }
}
