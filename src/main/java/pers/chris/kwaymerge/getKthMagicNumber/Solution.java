package pers.chris.kwaymerge.getKthMagicNumber;

class Solution {
    public int getKthMagicNumber(int k) {
        int[] cache = new int[k];
        cache[0] = 1;
        // 三序列指针
        int idx3 = 0;
        int idx5 = 0;
        int idx7 = 0;

        for (int i = 1; i < k; i++) {
            // 三序列最小值
            int num3 = cache[idx3] * 3;
            int num5 = cache[idx5] * 5;
            int num7 = cache[idx7] * 7;

            cache[i] = Math.min(Math.min(num3, num5), num7);
            // 三序列指针移动
            if (cache[i] == num3) {
                idx3++;
            }
            if (cache[i] == num5) {
                idx5++;
            }
            if (cache[i] == num7) {
                idx7++;
            }
        }
        return cache[k - 1];
    }
}
