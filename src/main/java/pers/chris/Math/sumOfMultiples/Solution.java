package pers.chris.Math.sumOfMultiples;

/**
 * @Description
 * @Author Chris
 * @Date 2023/10/17
 */
class Solution {
    public int sumOfMultiples(int n) {
        return (int) (f(n, 3) + f(n, 5) +f(n, 7)- f(n, 3 * 5) - f(n, 3 * 7) - f(n, 5 * 7) + f(n, 3 * 5 * 7));
    }

    public double f(int n, int m) {
        return (m + (double) (n / m) * m) * (double) (n / m) / 2;
    }
}
