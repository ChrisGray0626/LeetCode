package pers.chris.Hash.singleNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/16
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // If the set already contains the number, remove it
            if (set.contains(num)) {
                set.remove(num);
            }
            // If the set does not contain the number, add it
            else {
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
