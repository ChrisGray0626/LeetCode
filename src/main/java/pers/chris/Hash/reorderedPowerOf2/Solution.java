package pers.chris.Hash.reorderedPowerOf2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    Set<String> set = new HashSet<>();

    public boolean reorderedPowerOf2(int n) {
        // 2的幂数预处理
        for (int i = 1; i < 1e9; i <<= 1) {
            set.add(countDigits(i));
        }
        return set.contains(countDigits(n));
    }

    // 每个数字出现次数统计，用字符串形式存储
    public String countDigits(int n) {
        char[] cnt = new char[10];

        while (n > 0) {
            ++cnt[n % 10];
            n /= 10;
        }
        return Arrays.toString(cnt);
    }

}
