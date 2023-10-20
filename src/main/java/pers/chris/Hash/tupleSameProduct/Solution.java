package pers.chris.Hash.tupleSameProduct;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/19
 */
class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i : map.values()) {
            res += i * (i - 1) / 2 * 8;
        }
        return res;
    }
}
