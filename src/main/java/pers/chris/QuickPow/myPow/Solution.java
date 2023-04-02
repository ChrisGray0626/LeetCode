package pers.chris.QuickPow.myPow;

/**
 * @Description
 * @Author Chris
 * @Date 2023/3/31
 */
public class Solution {

    public double myPow(double x, int n) {
        long N = n;
        return N < 0 ? 1 / quickPow(x, -N) : quickPow(x, N);
    }

    public double quickPow(double x, long n) {
        if (0 == n) {
            return 1;
        }
        double y = quickPow(x, n / 2);
        y = y * y;
        if (n % 2 == 1) {
            y *= x;
        }
        return y;
    }
}
