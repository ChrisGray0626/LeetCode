package pers.chris.DynamicProgramming.reverseBits;

class Solution {
    public int reverseBits(int num) {
        int curLen = 0;
        int insertLen = 0;
        int res = 0;

        for (int i = 0; i < 32; i++) {
            if ((num & (1 << i)) == 1) {
                curLen++;
            }
            else {
                insertLen = curLen + 1;
                curLen = 0;
            }
            res = Math.max(res, insertLen);
        }
        return res;
    }
}
