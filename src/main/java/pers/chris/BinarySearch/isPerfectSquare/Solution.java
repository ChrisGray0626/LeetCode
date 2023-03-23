package pers.chris.BinarySearch.isPerfectSquare;

class Solution {
    public boolean isPerfectSquare(int num) {
        if (num ==  1) {
            return true;
        }

        long l = 0;
        long r = num / 2;

        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= num) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return l * l == num;
    }
}