package pers.chris.BitOperation.HammingWeight;

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;

        for (int i = 0; i < 32; i ++){
            // n与2的i次方进行与运算
            if ((n & (i << i)) != 0){
                res ++;
            }
        }
        return res;
    }
}
