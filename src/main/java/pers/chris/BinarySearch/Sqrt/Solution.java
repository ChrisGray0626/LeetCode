package pers.chris.BinarySearch.Sqrt;

class Solution {
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        int res = -1;
        while (left < right){
            int mid = (left + right) / 2;
            if ((long) mid * mid > x){
                right = mid - 1;
            }
            else {
                left = mid + 1;
                res = mid;
            }
        }

        return res;
    }
}
