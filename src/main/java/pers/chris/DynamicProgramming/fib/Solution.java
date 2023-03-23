package pers.chris.DynamicProgramming.fib;

class Solution {

    private static final int MOD = 1000000007;
    private static final int N = 110;
    // 共享缓存
    private static int[] cache = new int[N];

    public int fib(int n) {
        return calculate(n);
    }

    private int calculate(int n) {
        if (n < 2) {
            return n;
        }
        // 若缓存中已有计算值，则直接返回
        if (cache[n] != 0) {
            return cache[n];
        }
        // 计算并缓存
        cache[n] = (calculate(n - 1) + calculate(n - 2)) % MOD;
        return cache[n];
    }
}
