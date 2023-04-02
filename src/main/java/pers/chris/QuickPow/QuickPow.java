package pers.chris.QuickPow;

public class QuickPow {
    final int MOD = 1000000000 + 7;
    public double quickPow(double base, long power){
        double res = 1;
        while(power > 0){
            if((power & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            power >>= 1;
        }
        return res;
    }
}
