package pers.chris.BitOperation.ReverseBits;

public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i ++) {
            res |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return res;
    }
}