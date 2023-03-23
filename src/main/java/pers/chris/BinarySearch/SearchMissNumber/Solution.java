package pers.chris.BinarySearch.SearchMissNumber;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] map = new int[n + 1];
        int res = 0;

        for (int value: nums){
            map[value] = 1;
        }

        for (int i = 0; i < map.length; i ++){
            if (map[i] == 0){
                res = i;
            }
        }
        return res;
    }
}
