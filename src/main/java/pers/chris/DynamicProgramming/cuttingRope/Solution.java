package pers.chris.DynamicProgramming.cuttingRope;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/24
 */
class Solution {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        dp[3] = BigInteger.valueOf(3);

        for (int i = 4; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
            }
        }

        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public int cuttingRope2(int n) {
        if (n < 4) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        int res = 1;
        int MOD = 1000000007;

        for (int i = 0; i < quotient; i++) {
            res = res * 3 % MOD;
        }
         if (remainder == 1) {
            res = res / 3 * 4 % MOD;
        } else if (remainder == 2) {
            res = res * 2 % MOD;
        }

         return res;
    }

}