package pers.chris.Simulation.maxLengthBetweenEqualCharacters;

import java.util.Arrays;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        int [] firstIdxs = new int[26];
        Arrays.fill(firstIdxs, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (firstIdxs[ch - 'a'] == -1) {
                firstIdxs[ch - 'a'] = i;
            } else {
                res = Math.max(res, i - firstIdxs[ch - 'a'] - 1);
            }
        }
        return res;
    }
}
