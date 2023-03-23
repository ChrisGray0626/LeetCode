package pers.chris.Contest.Single248.CountGoodNumbers;

class Solution {
    final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (long) Math.ceil((double) n / 2);
        long odd = (long) n - even;
        int res = (int) ((quickPow(5, even) % MOD * (quickPow(4, odd) % MOD)) % MOD);
        return res;
    }

    public long quickPow(long base, long power){
        long result=1;
        while(power>0){
            if((power & 1) == 1) {
                result = result * base % MOD;
            }
            power>>=1;
            base = base * base % MOD;
        }
        return result;
    }
}
