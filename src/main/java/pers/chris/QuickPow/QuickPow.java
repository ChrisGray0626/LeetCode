package pers.chris.QuickPow;

public class QuickPow {
    final int MOD = 1000000000 + 7;
    public long quickPow(long base, long power){
        long res = 1;
        while(power > 0){
            if((power & 1) == 1) {
                res = res * base % MOD;
            }
            power >>= 1;
            base = base * base % MOD;
        }
        return res;
    }
}
