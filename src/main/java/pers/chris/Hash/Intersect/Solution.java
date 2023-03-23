package pers.chris.Hash.Intersect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums1){
            int value = map.getOrDefault(num, 0);
            map.put(num, ++ value);
        }

        int[] intersect = new int[nums1.length];
        int idx = 0;
        for (int num: nums2){
            if (map.containsKey(num)){
                intersect[idx ++] = num;

                int count = map.get(num);
                count --;
                if (count > 0){
                    map.put(num, count);
                }
                else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersect, 0, idx);
    }
}
