package pers.chris.Greedy.MinDeletions;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        char[] ss = s.toCharArray();
        int[] nums = new int[26];

        for (char ch: ss){
            nums[ch - 'a'] ++;
        }

        Set<Integer> set = new HashSet<Integer>();
        int res = 0;

        for (int num: nums){
            if (num != 0){
                while (set.contains(num)){
                    num --;
                    res ++;
                }

                if (num != 0){
                    set.add(num);
                }
            }
        }

        return res;
    }
}
