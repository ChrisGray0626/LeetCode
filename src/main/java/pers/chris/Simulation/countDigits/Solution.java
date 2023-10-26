package pers.chris.Simulation.countDigits;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/26
 */
class Solution {
    public int countDigits(int num) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = num;
        int base = 10;
        while (n != 0) {
            int bit = n % base;
            n /= base;
            countMap.put(bit, countMap.getOrDefault(bit, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int bit = entry.getKey();
            int count = entry.getValue();
            if (num % bit == 0) {
                res += count;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigits(1248));
    }
}
