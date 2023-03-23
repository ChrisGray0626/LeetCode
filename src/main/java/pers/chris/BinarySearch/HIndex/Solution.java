package pers.chris.BinarySearch.HIndex;

class Solution {

    int[] citations;

    public int hIndex(int[] citations) {
        this.citations = citations;
        int n = citations.length;
        int l = 0, r  = n;

        while (l < r){
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }

        return r;
    }

    boolean check(int mid) {
        int res = 0;
        for (int citation: citations) {
            if (citation >= mid) {
                res ++;
            }
        }
        return res >= mid;
    }
}
