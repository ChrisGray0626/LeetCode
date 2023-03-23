package pers.chris.Math.SmallestGoodBase;

public class Solution {
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 0;
            for (int i = 0; i <= m; i++) {
                sum += mul;
                mul *= k;
            }

            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return String.valueOf(nVal - 1);
    }
}
